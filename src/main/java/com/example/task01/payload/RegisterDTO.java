package com.example.task01.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author Sanjarbek Allayev, вс 12:37. 24.04.2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    @NotNull
    private String fullName;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String prePassword;
}
