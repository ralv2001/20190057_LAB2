package com.example.clase1gtics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "shippers")
@Getter
@Setter
public class Shipper {

    //Esto significa que es el Primary Key
    @Id
    //GeneratedValue significa que es autoincremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shipperId;

    //nullable = false significa que es not null
    @Column(name = "companyname",nullable = false,length = 40)
    private String companyname;

    private String phone;
}
