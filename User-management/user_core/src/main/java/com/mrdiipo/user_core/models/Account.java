package com.mrdiipo.user_core.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Size(min = 5, message = "Username must have a minimum of 5 characters")
    private String username;

    @Size(min = 8, message = "Password must have a minimum of 8 characters")
    private String password;

    @NotNull(message = "Specify at least one role")
    private List<Role> roles;

}
