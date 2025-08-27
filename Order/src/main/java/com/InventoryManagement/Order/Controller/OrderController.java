package com.InventoryManagement.Order.Controller;

import com.InventoryManagement.Order.DTO.OrderRequest;
import com.InventoryManagement.Order.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;
    @PostMapping
    @RequestMapping("/placeOrder")
    @ResponseStatus(HttpStatus.OK)
    public void placeOrder(@RequestBody OrderRequest orderRequest){
        orderService.placeOrder(orderRequest);
    }
}
