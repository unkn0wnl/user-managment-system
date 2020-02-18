package com.fintech.testproject.validator;

import com.fintech.testproject.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameUniqueValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    private UserAccountService userAccountService;

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !userAccountService.isUserNameAlreadyExist(value);
    }

}