package com.BuildMicroservice.product.service;

import com.BuildMicroservice.product.dto.ProductRequest;
import com.BuildMicroservice.product.model.Product;
import com.BuildMicroservice.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // generates a constructor with
@Slf4j
public class ProductService {
    // going to inject the product repository interface
    private final ProductRepository productRepository;

    public Product createProduct(ProductRequest productRequest) {
        // Create product
        // Create a new product object
        Product product = Product.builder()
                //.id(productRequest.id())
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        // Save the product object to the database
        productRepository.save(product);
        log.info("Product created successfully");
        // now  we have to return the product object that we have created
        return product;

    }
    // wait instead of returning the product class which is a model class we can create another DTO class called as ProductResponse we will map
    //the product object to the ProductResponse object and return the ProductResponse object


    public List<Product> getAllProducts() {
        // Get all products
        return productRepository.findAll();
    }
}
