package com.tvaprodut.saleweb.model;



import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "payments")
public class Payment implements Serializable {
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
