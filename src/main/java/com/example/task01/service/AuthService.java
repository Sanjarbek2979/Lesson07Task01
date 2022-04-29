package com.example.task01.service;

import com.example.task01.entity.Role;
import com.example.task01.entity.User;
import com.example.task01.exceptions.ResourceNotFoundException;
import com.example.task01.payload.ApiResponse;
import com.example.task01.payload.RegisterDTO;
import com.example.task01.repository.RoleRepository;
import com.example.task01.repository.UserRepository;
import com.example.task01.utils.AppConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Sanjarbek Allayev, вс 12:43. 24.04.2022
 */
@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
    final UserRepository userRepository;
    final RoleRepository roleRepository;
    final PasswordEncoder passwordEncoder;

    public ApiResponse registerUser(RegisterDTO registerDTO) {
        if (!registerDTO.getPassword().equals(registerDTO.getPrePassword())) {
            return new ApiResponse("Parollar mos emas", false);
        }
        if (userRepository.existsByUsername(registerDTO.getUsername())) {
            return new ApiResponse("Bunday username li user avval ro`yhatdan o`tgan", false
            );
        }

        User user = new User(registerDTO.getFullName(),
                registerDTO.getUsername(),
                passwordEncoder.encode(registerDTO.getPassword()),
                roleRepository.findByName(AppConstants.USER).orElseThrow(() -> new ResourceNotFoundException("role","name",AppConstants.USER)),
                true,true,true,true
                );
        User save = userRepository.save(user);

        return new ApiResponse("Muvaffaqiyatli ro`yhatdan o`tdingiz",true,save);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
