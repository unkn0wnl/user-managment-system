package com.fintech.testproject.model;

import java.util.regex.Pattern;

public interface AppConstants {

    interface UserConstants {
        int MIN_USERNAME_LENGTH = 3;
        int MAX_USERNAME_LENGTH = 16;

        int MIN_PASSWORD_LENGTH = 3;
        int MAX_PASSWORD_LENGTH = 16;

        int MIN_FIRST_NAME_LENGTH = 1;
        int MAX_FIRST_NAME_LENGTH = 16;

        int MIN_LAST_NAME_LENGTH = 1;
        int MAX_LAST_NAME_LENGTH = 16;

        String USERNAME_MATCH_PATTERN = "^[a-zA-Z]+$";
        String PASSWORD_MATCH_PATTERN = "^(?=.*[0-9])(?=.*[a-z])([a-z0-9_-]+)$";
        String FIRST_NAME_MATCH_PATTERN = "^[a-zA-Z]+$";
        String LAST_NAME_MATCH_PATTERN = "^[a-zA-Z]+$";
    }

}