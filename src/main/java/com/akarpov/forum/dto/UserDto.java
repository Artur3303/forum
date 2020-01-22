package com.akarpov.forum.dto;

import com.akarpov.forum.annotation.PasswordMatches;
import com.akarpov.forum.annotation.UniqueUsername;
import com.akarpov.forum.annotation.ValidPassword;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@PasswordMatches
public class UserDto {

    @NotNull
    @NotEmpty
    @UniqueUsername
    private String username;

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    @ValidPassword
    private String password;

    @NotNull
    @NotEmpty
    private String matchingPassword;

}
