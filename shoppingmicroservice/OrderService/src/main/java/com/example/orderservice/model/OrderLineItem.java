package com.example.orderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.record.UnalignedMemoryRecords;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="order_line")
public class OrderLineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderLineId;
    private int quantity;
    private String skuCode;
    private double price;

}
