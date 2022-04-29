package com.example.task01.repository;

import com.example.task01.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Sanjarbek Allayev, вс 12:56. 24.04.2022
 */
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(String name);
    boolean existsByName(String name);
}
