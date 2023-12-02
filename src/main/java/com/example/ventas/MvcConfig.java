package com.example.ventas;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/categories").setViewName("categories");
        registry.addViewController("/products").setViewName("products");
        registry.addViewController("/contact").setViewName("contact");
        registry.addViewController("/about").setViewName("about");   
        registry.addViewController("/soon").setViewName("cooming_soon");
         
    }

}
