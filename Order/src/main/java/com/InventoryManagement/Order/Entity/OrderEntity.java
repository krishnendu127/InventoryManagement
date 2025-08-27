package com.InventoryManagement.Order.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "order")
public class OrderEntity {
    @Id
    private String id;
    private List<String> productId;
    private List<String> quantity;
    private String shippingDetails;
    private boolean payment;
}
