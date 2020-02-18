package com.fintech.testproject.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public interface SecurityService {
    void autoLogin(String username, String password);

    String getLoginErrorMessage(HttpSession session);
}
