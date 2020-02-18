package com.fintech.testproject.service.impl;

import com.fintech.testproject.exception.UserAccountNotFoundException;
import com.fintech.testproject.model.enity.Role;
import com.fintech.testproject.model.enity.RoleNames;
import com.fintech.testproject.model.enity.UserAccount;
import com.fintech.testproject.repository.UserAccountRepository;
import com.fintech.testproject.service.RoleService;
import com.fintech.testproject.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private RoleService roleService;
    private PasswordEncoder passwordEncoder;
    private UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountServiceImpl(RoleService roleService,
                                  PasswordEncoder passwordEncoder, UserAccountRepository userAccountRepository) {
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserAccount findById(Long id) {
        return userAccountRepository
                .findById(id)
                .orElseThrow(() -> new UserAccountNotFoundException(String.format("User with ID: %d not found!", id)));
    }

    @Override
    public List<UserAccount> getAll() {
        return userAccountRepository.findAll();
    }

    @Override
    public void save(String username, String password, String firstName, String lastName, RoleNames role) {
        UserAccount userAccount = new UserAccount(username,
                passwordEncoder.encode(password),
                firstName,
                lastName,
                true);
        Role userRole = roleService.findRoleByName(role);
        userAccount.setRoles(new HashSet<>(Collections.singleton(userRole)));
        userAccountRepository.save(userAccount);
    }

    @Override
    public void rewrite(Long id, String firstName, String lastName, RoleNames role, boolean isEnable) {
        UserAccount userAccount = this.findById(id);
        Role roles = roleService.findRoleByName(role);

        userAccount.setFirstName(firstName);
        userAccount.setLastName(lastName);
        userAccount.setRoles(new HashSet<>(Collections.singleton(roles)));
        userAccount.setEnabled(isEnable);

        userAccountRepository.saveAndFlush(userAccount);
    }

    @Override
    public boolean isUserNameAlreadyExist(String username) {
        return userAccountRepository.findUserAccountByUsername(username).isPresent();
    }

    @Override
    public void changeUserStatus(Long id, boolean status) {
        UserAccount userAccount = this.findById(id);
        userAccount.setEnabled(status);
        userAccountRepository.saveAndFlush(userAccount);
    }

}