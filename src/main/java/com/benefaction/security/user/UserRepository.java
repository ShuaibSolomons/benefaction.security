package com.benefaction.security.user;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Cacheable(value = "user")
    Optional<User> findByEmail(String email);
}
