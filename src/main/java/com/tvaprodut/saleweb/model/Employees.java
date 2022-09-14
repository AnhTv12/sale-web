package com.tvaprodut.saleweb.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, length = 11)
    private int id;

    @Column(name="lastName")
    private String lastName;

    @Column(name="firstName")
    private String firstName;

    @Column(name="extension")
    private String extension;

    @Column(name="email")
    private String email;

    @Column(name="officeCode")
    private String officeCode;

    @Column(name="reportsTo")
    private int reportsTo;

    @Column(name="jobTitle")
    private String  jobTitle;

}
