package com.mrdiipo.user_command_api.commands;

import com.mrdiipo.user_core.models.User;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
public class RemoveUserCommand {

    @TargetAggregateIdentifier
    private String id;

}
