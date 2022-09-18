package com.tvaprodut.saleweb.entity;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Table(name = "student")
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stuID")
    private int stuID;

    @Column(name = "name")

    private String name;
    @Column(name = "gender")
    private String gender;

    @Column(name = "birth_day")
    private LocalDate birth_day;

    @Column(name = "hometown")
    private String hometown;
    @Column(name = "scholarship",nullable = true)
    private int scholarship;
    @Column(name = "faid")
    private int faid;



    public Student(String name, LocalDate birthday) {
        this.name = name;
        this.birth_day = birthday;
    }

    public Student(int id, String name, LocalDate birthday) {
        this.stuID = id;
        this.name = name;
        this.birth_day = birthday;
    }

    public int getId() {
        return stuID;
    }

    public void setId(int id) {
        this.stuID = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public int getScholarship() {
        return scholarship;
    }

    public void setScholarship(int scholarship) {
        this.scholarship = scholarship;
    }

    public int getFaid() {
        return faid;
    }

    public void setFaid(int faid) {
        this.faid = faid;
    }

    public LocalDate getBirthday() {
        return birth_day;
    }

    public void setBirthday(LocalDate birthday) {
        this.birth_day = birthday;
    }
}
