package com.whatsapp.api.backend.Configeration;


import jakarta.servlet.MultipartConfigElement;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.util.unit.DataSize;
;


@Configuration
public class FileUploadConfig {

    @Bean
    @Primary
    @Qualifier("imageMultipartConfig")
    public MultipartConfigElement imageMultipartConfig() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation("root/picture");
        factory.setFileSizeThreshold(DataSize.ofMegabytes(10));
        return factory.createMultipartConfig();
    }

    @Bean
    @Qualifier("documentMultipartConfig")
    public MultipartConfigElement documentMultipartConfig() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation("root/attachment");
        factory.setFileSizeThreshold(DataSize.ofMegabytes(10));
        return factory.createMultipartConfig();
    }

    @Bean
    @Qualifier("videoMultipartConfig")
    public MultipartConfigElement videoMultipartConfig() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation("root/video");
        factory.setFileSizeThreshold(DataSize.ofMegabytes(10));
        return factory.createMultipartConfig();
    }
}

