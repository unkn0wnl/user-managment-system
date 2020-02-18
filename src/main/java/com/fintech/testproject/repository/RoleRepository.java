package com.fintech.testproject.repository;

import com.fintech.testproject.model.enity.Role;
import com.fintech.testproject.model.enity.RoleNames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName (RoleNames roleName);
}