package com.mrdiipo.bankacccommandapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication //(exclude = {DataSourceAutoConfiguration.class})
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BankAccCommandApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccCommandApiApplication.class, args);
    }

}
