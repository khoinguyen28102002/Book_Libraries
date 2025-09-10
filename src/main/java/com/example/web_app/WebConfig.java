package com.example.web_app;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String imagePath = System.getProperty("user.dir") + "/../db/image/";
        registry.addResourceHandler("books/images/**")  
                .addResourceLocations("file:" + imagePath);
        System.out.println("Image path: " + imagePath);
    }
}

