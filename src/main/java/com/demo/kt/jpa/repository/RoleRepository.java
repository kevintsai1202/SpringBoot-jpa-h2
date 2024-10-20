package com.demo.kt.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.kt.jpa.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
