package com.mrdiipo.user_command_api.dto;

public class RegisterUserResponse extends BaseResponse{

    private String id;
    public RegisterUserResponse(String id, String message) {
        super(message);
        this.id = id;
    }
}
