package com.example.task01.service;

import com.example.task01.entity.Role;
import com.example.task01.payload.ApiResponse;
import com.example.task01.payload.RoleDTO;
import com.example.task01.payload.UserDTO;
import com.example.task01.repository.RoleRepository;
import com.example.task01.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Sanjarbek Allayev, вс 12:43. 24.04.2022
 */
@Service
@RequiredArgsConstructor
public class RoleService {
    final RoleRepository roleRepository;
    final PasswordEncoder passwordEncoder;


    public ApiResponse addRole(RoleDTO roleDTO) {
       if( roleRepository.existsByName(roleDTO.getName())){
           return new ApiResponse("Bunday role oldindan mavjud",false);
       }
        Role role = new Role(roleDTO.getName(), roleDTO.getPermissions(),roleDTO.getDescription());
        roleRepository.save(role);
        return new ApiResponse("Saqlandi",true);
    }
}
