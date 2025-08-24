package com.InventoryManagement.Product.Service;

import com.InventoryManagement.Product.Entity.ProductEntity;
import com.InventoryManagement.Product.Repository.ProductRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    public void createProduct(@RequestBody ){

    }
}
