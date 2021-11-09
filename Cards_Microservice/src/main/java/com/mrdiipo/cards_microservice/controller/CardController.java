package com.mrdiipo.cards_microservice.controller;

import com.mrdiipo.cards_microservice.model.Cards;
import com.mrdiipo.cards_microservice.model.Customer;
import com.mrdiipo.cards_microservice.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Elegbede Dipo
 */

@RestController
public class CardController {

    @Autowired
    CardRepository cardRepository;

    @PostMapping("/myCards")
    public List<Cards> getCardDetails(@RequestBody Customer customer){
        List<Cards> cards = cardRepository.findByCustomerId(customer.getCustomerId());
        if (cards != null) return  cards; else  return null;
    }
}
