package com.example.microservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

@Configuration
public class ProtoConfig {

    @Bean
    public ProtobufHttpMessageConverter protobufConverter() {
        return new ProtobufHttpMessageConverter();
    }
}
