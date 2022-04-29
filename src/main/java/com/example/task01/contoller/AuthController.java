package com.example.task01.contoller;

import com.example.task01.entity.User;
import com.example.task01.payload.ApiResponse;
import com.example.task01.payload.LoginDTO;
import com.example.task01.payload.RegisterDTO;
import com.example.task01.security.JwtProvider;
import com.example.task01.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
@RequestMapping("/api/auth")
public class AuthController {
    final AuthService authService;
    final AuthenticationManager authenticationManager;
    final JwtProvider jwtProvider;


    @PostMapping("/register")
    public HttpEntity<?> registerUser(@Valid @RequestBody RegisterDTO registerDTO){

        ApiResponse apiResponse=authService.registerUser(registerDTO);
    return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PostMapping("/login")
    public HttpEntity<?> loginUser(@Valid @RequestBody LoginDTO loginDTO){

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
        User user = (User) authenticate.getPrincipal();
        String token = jwtProvider.generateToken(user.getUsername());
        return ResponseEntity.ok(token);
    }
}
