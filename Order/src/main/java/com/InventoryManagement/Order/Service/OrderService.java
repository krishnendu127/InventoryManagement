package com.InventoryManagement.Order.Service;

import com.InventoryManagement.Order.DTO.OrderRequest;
import com.InventoryManagement.Order.Entity.OrderEntity;
import com.InventoryManagement.Order.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private OrderRepository orderRepository;
    public void placeOrder(OrderRequest orderRequest){
        OrderEntity orderEntity = OrderEntity.builder()
                .id(orderRequest.id())
                .quantity(orderRequest.quantity())
                .payment(orderRequest.payment())
                .productId(orderRequest.productId())
                .shippingDetails(orderRequest.shippingDetails())
                .build();
        if(orderEntity.getProductId().size() != orderEntity.getQuantity().size()) {
            throw new RuntimeException("Order validation failed!");
        }
        // validation for enough quantity there in inventory to be added
        orderRepository.save(orderEntity);
    }
}
