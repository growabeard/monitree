package com.witt.monitree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.witt.monitree.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}