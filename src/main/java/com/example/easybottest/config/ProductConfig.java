package com.example.easybottest.config;

import com.example.easybottest.model.Product;
import com.example.easybottest.model.ProductType;
import com.example.easybottest.service.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class ProductConfig {
    @Bean
    public <T extends Product> Map<ProductType, Service<T>> getProductMap(List<Service<T>> services) {
        return services.stream()
                .collect(Collectors.toMap(Service::getProductType, Function.identity()));
    }
}
