package com.example.hoteliermvc.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class CloudinaryConfiguration {
    @Autowired
    private CloudinaryConfigProperties cloudinary;


    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudinary.getCloudName(),
                "api_key", cloudinary.getApiKey(),
                "api_secret", cloudinary.getApiSecret()));
    }
}