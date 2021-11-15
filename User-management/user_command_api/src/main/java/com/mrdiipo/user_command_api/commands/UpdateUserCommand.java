package com.mrdiipo.user_command_api.commands;

import com.mrdiipo.user_core.models.User;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class UpdateUserCommand {
    @TargetAggregateIdentifier
    private String id;

    private User user;
}
