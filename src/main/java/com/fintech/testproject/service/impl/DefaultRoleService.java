package com.fintech.testproject.service.impl;

import com.fintech.testproject.exception.RoleNotFoundException;
import com.fintech.testproject.model.enity.Role;
import com.fintech.testproject.model.enity.RoleNames;
import com.fintech.testproject.repository.RoleRepository;
import com.fintech.testproject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class DefaultRoleService implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public DefaultRoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Set<Role> colletUserAccountRole(Long id) {
        Role role = this.roleRepository
                .findById(id)
                .orElseThrow(() -> new RoleNotFoundException(String.format("User Role with id %d not found!.", id)));
        return new HashSet<>(Collections.singletonList(role));
    }

    @Override
    public Role getFirstFromSet(Set<Role> roles) {
        return roles.stream().
                findFirst().orElseThrow(RoleNotFoundException::new);
    }

    @Override
    public Role findRoleById(Long id) {
        return this.roleRepository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException(String.format("User Role with ID: %s not found!.", id)));
    }

    @Override
    public Role findRoleByName(RoleNames role) {
        return this.roleRepository.findByName(role)
                .orElseThrow(() -> new RoleNotFoundException(String.format("User Role with name %s not found!.", role)));
    }

}