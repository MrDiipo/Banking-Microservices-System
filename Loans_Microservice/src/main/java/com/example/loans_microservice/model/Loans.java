package com.example.loans_microservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Loans {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "loan_number", nullable = false)
    private Long loanNumber;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "start_date")
    private Date startDt;

    @Column(name = "loan_type")
    private String loanType;

    @Column(name = "amount_paid")
    private String amountPaid;

    @Column(name = "outstanding_amount")
    private int outstandingAmount;

    @Column(name = "create_dt")
    private String createDt;


}
