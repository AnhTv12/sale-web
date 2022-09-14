package com.tvaprodut.saleweb.model;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "orderdetails")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "orderNumber", nullable = false, unique = true, length = 11)
    private int orderNumber;

    @Column(name="productCode")
    private String productCode;

    @Column(name="quantityOrdered")
    private int quantityOrdered;

    @Column(name="priceEach")
    private double priceEach;

    @Column(name = "orderLineNumber")
    private int orderLineNumber;

    public OrderDetail() {
    }

}
