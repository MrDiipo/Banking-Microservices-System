package com.example.loans_microservice.controller;

import com.mrdiipo.cards_microservice.model.Customer;
import com.mrdiipo.cards_microservice.model.Loans;
import com.mrdiipo.cards_microservice.repository.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    LoansRepository loansRepository;

    @PostMapping("/myLoans")
    public List<Loans> getLoansDetails(@RequestBody Customer customer){
        return loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
    }

}
