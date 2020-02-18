package com.fintech.testproject.web.payload;

import com.fintech.testproject.model.enity.RoleNames;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static com.fintech.testproject.model.AppConstants.UserConstants.*;

public class EditUserRequest {

    @NotBlank
    @Size(min = MIN_FIRST_NAME_LENGTH, max = MAX_FIRST_NAME_LENGTH)
    @Pattern(regexp = FIRST_NAME_MATCH_PATTERN)
    private String firstName;

    @NotBlank
    @Size(min = MIN_LAST_NAME_LENGTH, max = MAX_LAST_NAME_LENGTH)
    @Pattern(regexp = LAST_NAME_MATCH_PATTERN)
    private String lastName;

    private RoleNames role;

    @NotNull
    private Boolean enabled;

    public EditUserRequest() {
    }

    public EditUserRequest(String firstName, String lastName, RoleNames role, Boolean enabled) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.enabled = enabled;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public RoleNames getRole() {
        return role;
    }

    public void setRole(RoleNames role) {
        this.role = role;
    }

}