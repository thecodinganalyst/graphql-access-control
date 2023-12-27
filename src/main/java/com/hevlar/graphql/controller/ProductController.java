package com.hevlar.graphql.controller;

import com.hevlar.graphql.model.Product;
import com.hevlar.graphql.service.ProductService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
@RequiredArgsConstructor
public class ProductController {

    @NonNull
    private final ProductService productService;

    @QueryMapping
    public Flux<Product> listProducts(){
        return productService.list();
    }
}
