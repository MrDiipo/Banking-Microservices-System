package com.mrdiipo.user_command_api.controllers;

import com.mrdiipo.user_command_api.commands.RegisterUserCommand;
import com.mrdiipo.user_command_api.dto.RegisterUserResponse;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/registerUser")
public class RegisterUserController {

    private final CommandGateway commandGateway;

    public RegisterUserController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('WRITE_PRIVILEDGE')")
    public ResponseEntity<RegisterUserResponse> registerUser(@Valid @RequestBody RegisterUserCommand command){

        var id = UUID.randomUUID().toString();
        command.setId(id);
        try{
            commandGateway.send(command);
            return new ResponseEntity<RegisterUserResponse>(new RegisterUserResponse(id,"User successfully registered"), HttpStatus.CREATED);
        } catch (Exception e){
            var safeErrorMessage = "Error while processing register user request for id: " + command.getId();
            return new ResponseEntity<>(new RegisterUserResponse(id, safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
