package com.mrdiipo.user_query_api.handlers;

import com.mrdiipo.user_core.events.UserRegisteredEvent;
import com.mrdiipo.user_core.events.UserRemovedEvent;
import com.mrdiipo.user_core.events.UserUpdatedEvent;

public interface UserEventHandler {

    void on(UserRegisteredEvent event);
    void on(UserUpdatedEvent event);
    void on(UserRemovedEvent event);

}
