package com.dandh.userservice.repository;

import com.dandh.userservice.domain.Role;
import com.dandh.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
