package com.tvaprodut.saleweb.model;

import com.tvaprodut.saleweb.constants.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderNumber", nullable = false, unique = true, length = 11)
    private int orderNumber;

    @Column(name="orderDate")
    private LocalDate orderDate;

    @Column(name="requiredDate")
    private LocalDate requiredDate;

    @Column(name="shippedDate")
    private LocalDate shippedDate;

    @Column(name="status")
    private Status status;

    @Column(name="comments")
    private String comments;

    @Column(name="customerNumber")
    private int customerNumber;

}
