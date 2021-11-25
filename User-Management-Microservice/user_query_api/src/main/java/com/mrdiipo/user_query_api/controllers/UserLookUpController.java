package com.mrdiipo.user_query_api.controllers;

import com.mrdiipo.user_query_api.dto.UserLookUpResponse;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/usersLookup")
public class UserLookUpController {

    private final QueryGateway queryGateway;

    @Autowired
    public UserLookUpController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping(path = "/")
    public ResponseEntity<UserLookUpResponse> getAllUsers(){
     return null;
    }
}
