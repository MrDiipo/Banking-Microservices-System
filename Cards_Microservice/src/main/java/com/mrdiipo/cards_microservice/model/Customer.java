package com.mrdiipo.cards_microservice.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Customer {

    @Column(name = "customer_id")
    @Id
    private int customerId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile_number")
    private int mobileNumber;

    @Column(name = "create_dt")
    private LocalDate createDate;

}
