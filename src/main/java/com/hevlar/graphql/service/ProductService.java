package com.hevlar.graphql.service;

import com.hevlar.graphql.model.Product;
import com.hevlar.graphql.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Flux<Product> list(){
        return productRepository.findAll();
    }
}
