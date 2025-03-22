package com.toyproject.board.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginForm {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
