package com.tvaprodut.saleweb.model;

import javax.persistence.*;
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
    @Column(name = "employeeNumber", nullable = false, unique = true, length = 11)
    private int employeeNumber;

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
    private Integer reportsTo;

    @Column(name="jobTitle")
    private String  jobTitle;

    @Column(name = "id")
    private int id;

}
