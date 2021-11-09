package com.mrdiipo.accounts_microservice.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Accounts {

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "account_number")
    @Id
    private Long accountNumber;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "branch_address")
    private String branchAddress;

    @Column(name = "create_dt")
    private LocalDate createDate;

}
