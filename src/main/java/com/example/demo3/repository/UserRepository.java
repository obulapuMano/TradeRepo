package com.example.demo3.repository;

import com.example.demo3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Boolean existsByUserId(String userId);

    Optional<User> findByUserId(String username);
}
