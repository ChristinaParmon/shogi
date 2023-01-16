package com.example.shogi.repository;
import com.example.shogi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Long> {
    Optional <User> findByUsername(String username);
}
