package com.mrdiipo.user_command_api.commands;

import com.mrdiipo.user_core.models.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class RegisterUserCommand {

    @TargetAggregateIdentifier
    private String id;

    @NotNull(message = "No user details was supplied")
    @Valid
    private User user;
}
