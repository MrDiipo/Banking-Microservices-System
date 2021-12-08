package com.mrdiipo.user_command_api.dto;

import com.mrdiipo.user_core.dto.BaseResponse;

public class RegisterUserResponse extends BaseResponse {

    private String id;
    public RegisterUserResponse(String id, String message) {
        super(message);
        this.id = id;
    }
}
