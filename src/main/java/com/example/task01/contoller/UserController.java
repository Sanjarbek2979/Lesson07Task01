package com.example.task01.contoller;

import com.example.task01.payload.ApiResponse;
import com.example.task01.payload.RegisterDTO;
import com.example.task01.payload.UserDTO;
import com.example.task01.service.AuthService;
import com.example.task01.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/user")
public class UserController {
    final UserService userService;


    @PostMapping("/register")
    public HttpEntity<?> registerUser(@Valid @RequestBody UserDTO userDTO){

        ApiResponse apiResponse=userService.addUser(userDTO);
    return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}
