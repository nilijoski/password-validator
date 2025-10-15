package com.example;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class PasswordValidator extends AbstractPasswordValidator {

    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

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
    public boolean containsSpecialChar(String password, String specialChars) {
        if (password == null || password.isEmpty() || specialChars == null || specialChars.isEmpty()) {
            return false;
        }

        for (char c : password.toCharArray()) {
            if (specialChars.indexOf(c) >= 0) {
                return true;
            }
        }

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

    public boolean isValid(String password, String specialChars) {
        if (!containsSpecialChar(password, specialChars)) {
            return false;
        }

        return isValid(password);
    }


    public String generateSecurePassword(int length, String specialChars) {
        if (length < 8) {
            throw new IllegalArgumentException("Password length must be at least 8 characters");
        }
        if (specialChars == null || specialChars.isEmpty()) {
            throw new IllegalArgumentException("Allowed special characters cannot be null or empty");
        }

        List<Character> chars = new ArrayList<>();
        chars.add(randomChar(UPPER));
        chars.add(randomChar(LOWER));
        chars.add(randomChar(DIGITS));
        chars.add(randomChar(specialChars));

        String all = UPPER + LOWER + DIGITS + specialChars;
        while (chars.size() < length) {
            chars.add(randomChar(all));
        }

        Collections.shuffle(chars, RANDOM);

        StringBuilder password = new StringBuilder();
        for (char c : chars) {
            password.append(c);
        }

        if (!isValid(password.toString(), specialChars)) {
            return generateSecurePassword(length, specialChars);
        }

        return password.toString();
    }

    private static char randomChar(String source) {
        return source.charAt(RANDOM.nextInt(source.length()));
    }
}

