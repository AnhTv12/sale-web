package com.tvaprodut.saleweb.model;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "cart")
@Builder
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
