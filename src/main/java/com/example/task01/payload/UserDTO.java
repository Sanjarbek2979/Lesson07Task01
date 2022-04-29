package com.example.task01.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author Sanjarbek Allayev, вс 14:17. 24.04.2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @NotNull
    private String fullName;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private Long roleId;


}
