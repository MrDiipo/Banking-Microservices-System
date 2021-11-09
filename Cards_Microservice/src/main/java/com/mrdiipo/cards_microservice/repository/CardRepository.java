package com.mrdiipo.cards_microservice.repository;

import com.mrdiipo.cards_microservice.model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Cards, Long> {
    List<Cards> findByCustomerId(int customerId);
}
