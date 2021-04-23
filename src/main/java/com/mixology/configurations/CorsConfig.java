package com.mixology.configurations;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer{

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // TODO Auto-generated method stub
        registry.addMapping("/**") // all endpoints in the api
                .allowedOrigins("http://localhost:4200") // YOU MIGHT HAVE TO ADD OR CHANGE
                .allowedMethods("PUT", "DELETE", "GET", "OPTIONS", "POST", "PATCH")
                .allowedHeaders("header1", "Content-Type", "Authorization","Access-Control-Allow-Origin")//YOU MIGHT HAVE TO ADD HEADERS
//        .exposedHeaders("header1", "header2")
                .allowCredentials(true);
    }


}