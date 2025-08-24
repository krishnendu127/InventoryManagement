package com.InventoryManagement.Supplier.Service;

import com.InventoryManagement.Supplier.DTO.SupplierRequest;
import com.InventoryManagement.Supplier.Entity.ProductEntity;
import com.InventoryManagement.Supplier.Entity.SupplierEntity;
import com.InventoryManagement.Supplier.Repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public void addSupplier(SupplierRequest supplierRequest){
        SupplierEntity supplierEntity = SupplierEntity.builder()
                .id(supplierRequest.id())
                .name(supplierRequest.name())
                .email(supplierRequest.email())
                .products(supplierRequest.products())
                .build();
        supplierRepository.save(supplierEntity);
    }
    public void deleteSupplier(String id){
        supplierRepository.deleteById(id);
    }
    public void addProductBySupplier(String id, ProductEntity productEntity){
        SupplierEntity supplierEntity = supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("No such Supplier found with given id"));
        List<ProductEntity> productList = supplierEntity.getProducts();
        productList.add(productEntity);
        supplierRepository.save(supplierEntity);
    }
    public void deleteProductBySupplier(String supplierId, String productId){
        SupplierEntity supplierEntity = supplierRepository.findById(supplierId).orElseThrow(() -> new RuntimeException("No such Supplier found with given Supplier ID"));
        List<ProductEntity> productList = supplierEntity.getProducts();
        List<ProductEntity> modifiedProductList = new ArrayList<>();
        for(ProductEntity product : productList){
            if(!product.getProductId().equals(productId)){
                modifiedProductList.add(product);
            }
        }
        supplierEntity.setProducts(modifiedProductList);
        supplierRepository.save(supplierEntity);
    }
}
