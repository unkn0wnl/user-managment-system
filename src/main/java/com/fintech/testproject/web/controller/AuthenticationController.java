package com.fintech.testproject.web.controller;


import com.fintech.testproject.service.SecurityService;
import com.fintech.testproject.service.UserAccountService;
import com.fintech.testproject.web.payload.NewUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.fintech.testproject.web.WebConstants.ERROR_MESSAGE_ATTRIBUTE;

@Controller
public class AuthenticationController {

    private final SecurityService securityService;
    private final UserAccountService userAccountService;

    @Autowired
    public AuthenticationController(SecurityService securityService, UserAccountService userAccountService) {
        this.securityService = securityService;
        this.userAccountService = userAccountService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/login-error")
    public String login(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        String errorMessage = securityService.getLoginErrorMessage(session);
        model.addAttribute(ERROR_MESSAGE_ATTRIBUTE, errorMessage);
        return "auth/login";
    }

    @GetMapping("/register")
    public String register(WebRequest request, Model model) {
        model.addAttribute("registrationForm", new NewUserRequest());
        return "auth/register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute(name = "registrationForm") NewUserRequest registrationRequest,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return "auth/register";
        }
        userAccountService.save(registrationRequest.getUsername(),
                registrationRequest.getPassword(),
                registrationRequest.getFirstName(),
                registrationRequest.getLastName(),
                registrationRequest.getRole());
        securityService.autoLogin(registrationRequest.getUsername(), registrationRequest.getPassword());
        return "user/usersList";
    }

}