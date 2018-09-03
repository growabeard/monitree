package com.witt.monitree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.witt.monitree.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}