package com.example.task01.contoller;

import com.example.task01.payload.ApiResponse;
import com.example.task01.payload.RoleDTO;
import com.example.task01.payload.UserDTO;
import com.example.task01.service.RoleService;
import com.example.task01.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Sanjarbek Allayev, вс 12:33. 24.04.2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/role")
public class RoleController {
    final RoleService roleService;


    @PreAuthorize(value = "hasAuthority('ADD_ROLE')")
    @PostMapping
    public HttpEntity<?> addRole(@Valid @RequestBody RoleDTO roleDTO){

        ApiResponse apiResponse=roleService.addRole(roleDTO);
    return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}
