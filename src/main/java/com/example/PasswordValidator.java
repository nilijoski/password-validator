package com.example;

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

    @Override
    public boolean isCommonPassword(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        String lower = password.toLowerCase();
        String[] common = { "password", "password1", "12345678", "aa345678" };

        for (String weak : common) {
            if (lower.equals(weak)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsSpecialChar(String password, String allowed) {
        return false;
    }

    @Override
    public boolean isValid(String password) {
        return false;
    }

}
