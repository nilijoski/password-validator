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

    @Test
    void containsDigit_ShouldReturnFalse_WhenNoDigit() {
        assertFalse(passwordValidator.containsDigit("abcdef"));
    }

    @Test
    void containsDigit_ShouldReturnTrue_WhenExactlyOneDigit() {
        assertTrue(passwordValidator.containsDigit("abc1def"));
    }

    @Test
    void containsDigit_ShouldReturnTrue_WhenMultipleDigits() {
        assertTrue(passwordValidator.containsDigit("ab12cd34"));
    }

    @Test
    void containsDigit_ShouldReturnTrue_WhenOnlyDigits() {
        assertTrue(passwordValidator.containsDigit("123456"));
    }

    @Test
    void containsDigit_ShouldReturnFalse_WhenNull() {
        assertFalse(passwordValidator.containsDigit(null));
    }

    @Test
    void containsDigit_ShouldReturnFalse_WhenEmpty() {
        assertFalse(passwordValidator.containsDigit(""));
    }

}