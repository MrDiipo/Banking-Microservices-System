package com.mrdiipo.user_command_api.security;

public interface PasswordEncoder {
    String hashPassword(String password);
}
