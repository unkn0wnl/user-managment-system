package com.fintech.testproject.model.enity;

public enum RoleNames {

    ROLE_USER {
        @Override
        public String toString() {
            return "USER";
        }
    },

    ROLE_ADMIN {
        @Override
        public String toString() {
            return "ADMINISTRATOR";
        }
    }

}