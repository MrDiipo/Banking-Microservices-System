package com.mrdiipo.user_query_api.dto;

import com.mrdiipo.user_core.dto.BaseResponse;
import com.mrdiipo.user_core.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


public class UserLookUpResponse extends BaseResponse {
    private List<User> users;

    public UserLookUpResponse(String message) {
        super(message);
    }

    public UserLookUpResponse(List<User> users) {
        super(null);
        this.users = users;
    }

    public UserLookUpResponse(String message, User user) {
        super(message);
        this.users = new ArrayList<>();
        this.users .add(user);
    }

    public UserLookUpResponse(User user) {
        super(null);
        this.users = new ArrayList<>();
        this.users .add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
