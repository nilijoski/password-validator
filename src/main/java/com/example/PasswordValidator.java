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
        return false;
    }

    @Override
    public boolean containsUpperAndLower(String password) {
        return false;
    }

    @Override
    public boolean isCommonPassword(String password) {
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
