package com.example.accounts_microservice.controller;

import com.example.accounts_microservice.model.Accounts;
import com.example.accounts_microservice.model.Customer;
import com.example.accounts_microservice.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author  Elegbede Oladipupo
 */

@RestController
public class AccountsController {

    @Autowired
    AccountsRepository accountsRepository;

    @PostMapping("/myAccount")
    public Accounts getAccountsDetails(@RequestBody Customer customer){
        return accountsRepository.findByCustomerId(customer.getCustomerId());
    }
}
