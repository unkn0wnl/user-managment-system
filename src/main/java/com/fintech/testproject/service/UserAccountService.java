package com.fintech.testproject.service;

import com.fintech.testproject.model.enity.RoleNames;
import com.fintech.testproject.model.enity.UserAccount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserAccountService {

    UserAccount findById(Long id);

    List<UserAccount> getAll();

    void save(String username, String password, String firstName, String lastName, RoleNames role);

    void rewrite(Long id, String firstName, String lastName, RoleNames role, boolean isEnable);

    boolean isUserNameAlreadyExist(String username);

    void changeUserStatus(Long id, boolean status);

}