package com.mrdiipo.user_command_api.controllers;

import com.mrdiipo.user_command_api.commands.RemoveUserCommand;
import com.mrdiipo.user_core.dto.BaseResponse;
import com.mrdiipo.user_command_api.dto.RegisterUserResponse;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/removeUser")
public class RemoveUserController {

    private final CommandGateway commandGateway;

    @Autowired
    public RemoveUserController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('WRITE_PRIVILEDGE')")
    public ResponseEntity<BaseResponse> removeUser(@PathVariable(value = "id") String id,
                                                   @Valid @RequestBody RemoveUserCommand command){

        try {
            commandGateway.send(new RemoveUserCommand(id));
            return new ResponseEntity<>(new BaseResponse("User was successfully remove"), HttpStatus.OK);
        } catch (Exception e){
            var safeErrorMessage = "Error while processing remove user request for id: " + command.getId();
            return new ResponseEntity<>(new RegisterUserResponse(id, safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
