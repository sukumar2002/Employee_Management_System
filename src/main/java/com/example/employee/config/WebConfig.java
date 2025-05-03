package com.example.employee.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")  // Allow CORS for all endpoints starting with /api
                .allowedOrigins("http://localhost:5500")  // Adjust for your frontend's origin
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow HTTP methods
                .allowedHeaders("*");  // Allow all headers
    }
}
