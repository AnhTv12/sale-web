package com.tvaprodut.saleweb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;



@Entity
@Table(name = "cart")
@Builder
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, length = 11)
    private int id;

    @Column(name = "customerNumber")
    private int customerNumber;

    public Cart() {
    }

    public Cart(int yourCustomerNumber) {
        this.customerNumber = yourCustomerNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }
}
