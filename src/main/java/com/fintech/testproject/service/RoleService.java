package com.fintech.testproject.service;

import com.fintech.testproject.model.enity.Role;
import com.fintech.testproject.model.enity.RoleNames;

import java.util.Set;

public interface RoleService {
    Set<Role> colletUserAccountRole(Long id);

    Role getFirstFromSet(Set<Role> roles);

    Role findRoleById(Long id);

    Role findRoleByName(RoleNames names);
}
