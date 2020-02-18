package com.fintech.testproject.web.payload;

import com.fintech.testproject.model.enity.RoleNames;
import com.fintech.testproject.validator.UniqueUsername;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static com.fintech.testproject.model.AppConstants.UserConstants.*;

public class NewUserRequest {

    @NotBlank
    @Size(min = MIN_USERNAME_LENGTH, max = MAX_USERNAME_LENGTH)
    @Pattern(regexp = USERNAME_MATCH_PATTERN, message = "{username.pattern}")
    @UniqueUsername
    private String username;

    @NotBlank
    @Size(min = MIN_PASSWORD_LENGTH, max = MAX_PASSWORD_LENGTH)
    @Pattern(regexp = PASSWORD_MATCH_PATTERN, message = "{password.pattern}")
    private String password;

    @NotBlank
    @Size(min = MIN_FIRST_NAME_LENGTH, max = MAX_FIRST_NAME_LENGTH)
    @Pattern(regexp = FIRST_NAME_MATCH_PATTERN, message = "{firstname.pattern}")
    private String firstName;

    @NotBlank
    @Size(min = MIN_LAST_NAME_LENGTH, max = MAX_LAST_NAME_LENGTH)
    @Pattern(regexp = LAST_NAME_MATCH_PATTERN, message = "{lastname.pattern}")
    private String lastName;

    private RoleNames role;

    private Boolean enabled;

    public NewUserRequest() {
    }

    public RoleNames getRole() {
        return role;
    }

    public void setRole(RoleNames role) {
        this.role = role;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}