package com.example;

import java.util.Set;

public class PasswordValidator extends AbstractPasswordValidator {

    @Override
    public boolean hasMinLength(String password, int min) {
        if (min <= 0 || password == null) {
            return false;
        }

        if (password.length() > 36 || password.length() < min || password.contains(" ")) {
            return false;
        }

        return true;

    }

    @Override
    public boolean containsDigit(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        for (char c : password.toCharArray()) {
            if (c >= '0' && c <= '9') {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsUpperAndLower(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            }

            if (hasUpper && hasLower) {
                return true;
            }
        }

        return false;
    }

    private static final Set<String> COMMON_PASSWORDS = Set.of(
            "password",
            "password1",
            "12345678",
            "aa345678"
    );

    @Override
    public boolean isCommonPassword(String password) {
        if (password == null) {
            return false;
        }

        String normalized = password.trim().toLowerCase();

        if (normalized.isEmpty()) {
            return false;
        }

        return COMMON_PASSWORDS.contains(normalized);
    }

    @Override
    public boolean containsSpecialChar(String password, String allowed) {
        return false;
    }

    @Override
    public boolean isValid(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        if (!hasMinLength(password, 8)) {
            return false;
        }

        if (!containsDigit(password)) {
            return false;
        }

        if (!containsUpperAndLower(password)) {
            return false;
        }

        if (isCommonPassword(password)) {
            return false;
        }

        return true;
    }

}
