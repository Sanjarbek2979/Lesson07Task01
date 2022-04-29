package com.example.task01.component;

import com.example.task01.entity.Role;
import com.example.task01.entity.User;
import com.example.task01.entity.enums.Permission;
import com.example.task01.entity.enums.RoleTypes;
import com.example.task01.repository.RoleRepository;
import com.example.task01.repository.UserRepository;
import com.example.task01.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Sanjarbek Allayev, вс 13:04. 24.04.2022
 */
@Component
public class DataLoader implements CommandLineRunner {
    @Value(value = "${spring.sql.init.mode}")
    private String mode;

    @Value(value = "${spring.jpa.hibernate.ddl-auto}")
    private String ddl;


    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (ddl.equals("create") && mode.equals("always")) {
            Permission[] values = Permission.values();
            Role admin = roleRepository.save(new Role(AppConstants.ADMIN, Arrays.asList(values),"Admin sistema egasi"
            ));
            Role user = roleRepository.save(new Role(AppConstants.USER,
                    Arrays.asList(Permission.ADD_COMMENT, Permission.DELETE_MY_COMMENT, Permission.EDIT_COMMENT),"User oddiy foydalanuvchi"
            ));
            userRepository.save(new User(
                    "Admin",
                    "admin",
                    passwordEncoder.encode("admin123"),
                    admin,
                    true, true, true, true
            ));
            userRepository.save(new User(
                    "User",
                    "user",
                    passwordEncoder.encode("user123"),
                    user,
                    true, true, true, true
            ));
        }

    }
}
