package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordValidatorTest {

    private PasswordValidator passwordValidator;

    @BeforeEach
    void setUp() {
        passwordValidator = new PasswordValidator();
    }

    @Test
    void hasMinLength_ShouldReturnFalse_WhenLength7() {
        assertFalse(passwordValidator.hasMinLength("1234567", 8));
    }

    @Test
    void hasMinLength_ShouldReturnTrue_WhenLength8() {
        assertTrue(passwordValidator.hasMinLength("12345678", 8));
    }

    @Test
    void hasMinLength_ShouldReturnTrue_WhenLength10() {
        assertTrue(passwordValidator.hasMinLength("1234567890", 8));
    }

    @Test
    void hasMinLength_ShouldReturnFalse_WhenGivenNull() {
        assertFalse(passwordValidator.hasMinLength(null, 8));
    }


    @Test
    void hasMinLength_ShouldReturnFalse_WhenGivenBlankSpacesExist() {
        assertFalse(passwordValidator.hasMinLength(" 123 ", 5));
    }

    @Test
    void hasMinLength_ShouldReturnFalse_WhenLength0() {
        assertFalse(passwordValidator.hasMinLength("", 8));
    }

    @Test
    void hasMinLength_ShouldReturnFalse_WhenMinIsZero() {
        assertFalse(passwordValidator.hasMinLength("abc", 0));
    }

    @Test
    void hasMinLength_ShouldReturnFalse_WhenMinIsNegative() {
        assertFalse(passwordValidator.hasMinLength("abc", -1));
    }

    @Test
    void hasMinLength_ShouldReturnFalse_ForVeryLongPassword() {
        String longPassword = "a".repeat(1000);
        assertFalse(passwordValidator.hasMinLength(longPassword, 8));
    }

}