package com.mrdiipo.user_core.events;

import com.mrdiipo.user_core.models.User;
import lombok.Data;

@Data
public class UserRemovedEvent {
    private String id;
}
