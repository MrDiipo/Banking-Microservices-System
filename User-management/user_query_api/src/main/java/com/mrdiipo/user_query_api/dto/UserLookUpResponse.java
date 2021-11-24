package com.mrdiipo.user_query_api.dto;

import com.mrdiipo.user_core.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class UserLookUpResponse {
    private List<User> users;

    public UserLookUpResponse(User user) {
        this.users = new ArrayList<>();
        this.users .add(user);
    }
}
