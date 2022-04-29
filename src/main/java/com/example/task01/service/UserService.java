package com.example.task01.service;

import com.example.task01.entity.User;
import com.example.task01.exceptions.ResourceNotFoundException;
import com.example.task01.payload.ApiResponse;
import com.example.task01.payload.RegisterDTO;
import com.example.task01.payload.UserDTO;
import com.example.task01.repository.RoleRepository;
import com.example.task01.repository.UserRepository;
import com.example.task01.utils.AppConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Sanjarbek Allayev, вс 12:43. 24.04.2022
 */
@Service
@RequiredArgsConstructor
public class UserService {
    final UserRepository userRepository;
    final RoleRepository roleRepository;
    final PasswordEncoder passwordEncoder;

    public ApiResponse addUser(UserDTO userDTO) {

        return null;
    }
}
