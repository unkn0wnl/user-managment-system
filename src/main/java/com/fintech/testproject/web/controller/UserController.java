package com.fintech.testproject.web.controller;

import com.fintech.testproject.model.enity.Role;
import com.fintech.testproject.model.enity.UserAccount;
import com.fintech.testproject.service.RoleService;
import com.fintech.testproject.service.UserAccountService;
import com.fintech.testproject.web.WebConstants;
import com.fintech.testproject.web.payload.EditUserRequest;
import com.fintech.testproject.web.payload.NewUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

import static com.fintech.testproject.web.WebConstants.*;

@Controller
public class UserController {

    private RoleService roleService;
    private UserAccountService userAccountService;

    @Autowired
    public UserController(RoleService roleService, UserAccountService userAccountService) {
        this.roleService = roleService;
        this.userAccountService = userAccountService;
    }


    @GetMapping("/user")
    public String userList(Model model) {
        List<UserAccount> allUserAccounts = userAccountService.getAll();
        model.addAttribute(WebConstants.USER_LIST_ATTRIBUTE, allUserAccounts);
        return "user/usersList";
    }

    @GetMapping("/user/{userId}")
    public String userDetails(Model model, @PathVariable Long userId) {
        UserAccount userAccount = userAccountService.findById(userId);
        model.addAttribute(USER_ATTRIBUTE, userAccount);
        return "user/userDetails";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/user/{userId}")
    public String changeUserStatus(@PathVariable Long userId, @RequestParam(USER_LOCK_ATTRIBUTE) Boolean status) {
        if (Objects.nonNull(status)) {
            userAccountService.changeUserStatus(userId, status);
        }
        return "redirect:/user";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/user/{userId}/edit")
    public String editUser(Model model, @PathVariable Long userId) {
        UserAccount userAccount = userAccountService.findById(userId);
        Role userRole = roleService.getFirstFromSet(userAccount.getRoles());

        EditUserRequest currentUserAccountData = new EditUserRequest(userAccount.getFirstName(),
                userAccount.getLastName(),
                userRole.getName(),
                userAccount.isEnabled());
        model.addAttribute(EDIT_FORM_ATTRIBUTE, currentUserAccountData);
        return "user/editUser";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/user/{userId}/edit")
    public String editUser(@PathVariable Long userId,
                           @Valid @ModelAttribute(name = EDIT_FORM_ATTRIBUTE) EditUserRequest editRequest,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/editUser";
        }

        userAccountService.rewrite(userId,
                editRequest.getFirstName(),
                editRequest.getLastName(),
                editRequest.getRole(),
                editRequest.getEnabled());

        return "user/editUser";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/user/new")
    public String register(WebRequest request, Model model) {
        model.addAttribute(REGISTRATION_FORM_ATTRIBUTE, new NewUserRequest());
        return "user/newUser";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/user/new")
    public String createNewUser(@Valid @ModelAttribute(name = REGISTRATION_FORM_ATTRIBUTE) NewUserRequest registrationRequest,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/newUser";
        }

        userAccountService.save(registrationRequest.getUsername(),
                registrationRequest.getPassword(),
                registrationRequest.getFirstName(),
                registrationRequest.getLastName(),
                registrationRequest.getRole());
        return "redirect:/user";
    }

}