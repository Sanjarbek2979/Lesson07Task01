package com.example.task01.payload;

import com.example.task01.entity.enums.Permission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Sanjarbek Allayev, вс 14:26. 24.04.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleDTO {
    @NotBlank
    private String name;

    private String description;

    @NotEmpty
    private List<Permission> permissions;
}
