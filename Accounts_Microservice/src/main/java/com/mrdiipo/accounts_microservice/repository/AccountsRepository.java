package com.mrdiipo.accounts_microservice.repository;

import com.mrdiipo.accounts_microservice.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    Accounts findByCustomerId(int customerId);
}
