package com.example.ventas.service;

import com.example.ventas.entity.Detalle;
import com.example.ventas.entity.Producto;
import com.example.ventas.entity.Venta;
import com.example.ventas.entity.VentaDto;
import com.example.ventas.repository.DetalleRepository;
import com.example.ventas.repository.ProductoRepository;
import com.example.ventas.repository.VentaRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private DetalleRepository detalleRepository;
    @Autowired
    private ProductoRepository productoRepository;

    public List<Venta> ventaSel() {
        return ventaRepository.findAll();
    }

    public VentaDto ventaVistaGet(Integer id) {
        return ventaRepository.ventaVista(id);
    }

    public Venta ventaGet(Integer id) {
        return ventaRepository.findById(id).orElse(new Venta());
    }

    //Crear venta (Transaccional)
    @Transactional
    public void realizarVenta(Venta venta) {
        try {
            // Validar consistencia de datos
            List<Detalle> detalles;
            if (venta.getDetalles().size() <= 0) {
                throw new RuntimeException("Se debe agregar al menos un producto");
            } else {
                detalles = venta.getDetalles();
            }
            venta.setFecha(LocalDateTime.now());
            venta.setMonto(calcularMontoTotal(detalles));
            ventaRepository.save(venta);
            // Actualizar detalles con la venta recién creada
            for (Detalle detalle : detalles) {
                Producto producto = detalle.getProducto();
                //Validación de cantidad y precio
                if (detalle.getCantidad() < 1) {
                    throw new RuntimeException(String.format("Se debe agregar por lo menos una unidad para %s. Cantidad indicada %d",
                            producto.getNombre(), detalle.getCantidad()));
                } else if (detalle.getPrecio() < 0) {
                    throw new RuntimeException(String.format("El precio no puede ser negativo para %s. Precio indicado S/%.2f",
                            producto.getNombre(), detalle.getPrecio()));
                }
                //Calcular la nueva cantidad del producto
                int nuevaCantidad = producto.getCantidad() - detalle.getCantidad();
                if (nuevaCantidad < 0) {
                    // Lanzar una excepción si la cantidad es menor a 0
                    throw new RuntimeException(String.format("No hay suficientes existencias para el producto: %s", producto.getNombre()));
                }
                // Actualizar la cantidad de productos            
                producto.setCantidad(nuevaCantidad);
                detalle.setVenta(venta);
                detalleRepository.save(detalle);
                productoRepository.save(producto);
            }
        } catch (DataIntegrityViolationException e) {
            //Claves foráneas o campos que son inválidos o vacíos
            throw new RuntimeException(String.format("Error de integridad de datos: %s", e.getMessage()));
        }
    }

    private Float calcularMontoTotal(List<Detalle> detalles) {
        return detalles.stream().map(e -> e.getPrecio() * e.getCantidad()).reduce(Float::sum).get();
    }
}
