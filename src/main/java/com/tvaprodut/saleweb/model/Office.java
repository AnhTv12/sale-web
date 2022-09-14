package com.tvaprodut.saleweb.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "offices")
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "officeCode", nullable = false, unique = true, length = 11)
    private int officeCode;

    @Column(name="city")
    private String city;

    @Column(name="addressLine1")
    private String addressLine1;

    @Column(name="addressLine2")
    private String addressLine2;

    @Column(name="state")
    private String state;

    @Column(name="country")
    private String country;

    @Column(name="repopostalCodertsTo")
    private String postalCode;

    @Column(name="territory")
    private String  territory;

}
