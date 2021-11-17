package com.mrdiipo.user_query_api.dto;

import com.mrdiipo.user_core.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLookUpResponse {
    private User user;
}
