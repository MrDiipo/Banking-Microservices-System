package com.mrdiipo.bankaccqueryapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BankAccQueryApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccQueryApiApplication.class, args);
    }

}
