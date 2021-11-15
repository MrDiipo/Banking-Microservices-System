package com.mrdiipo.user_core.events;

import com.mrdiipo.user_core.models.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegisteredEvent {
    private String id;
    private User user;
}
