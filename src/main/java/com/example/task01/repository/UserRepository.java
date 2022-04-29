package com.example.task01.repository;

import com.example.task01.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Sanjarbek Allayev, вс 12:48. 24.04.2022
 */
public interface UserRepository extends JpaRepository<User,Long> {
boolean existsByUsername(String userName);

    Optional<User> findByUsername(String username);
}
