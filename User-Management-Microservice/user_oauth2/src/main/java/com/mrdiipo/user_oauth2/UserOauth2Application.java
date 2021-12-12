package com.mrdiipo.user_oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class UserOauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(UserOauth2Application.class, args);
    }

}
