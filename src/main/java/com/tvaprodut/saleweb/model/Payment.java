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
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerNumber", nullable = false, unique = true, length = 11)
    private int customerNumber;

    @Id
    @Column(name="checkNumber", length = 50)
    private String checkNumber;

    @Column(name="paymentDate")
    private LocalDate paymentDate;

    @Column(name="amount")
    private int amount;


}
