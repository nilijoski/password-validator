package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void hasMinLength_ShouldReturnFalse_WhenLength7() {
        PasswordValidator pv = new PasswordValidator();
        assertFalse(pv.hasMinLength("1234567", 8));
    }

    @Test
    void hasMinLength_ShouldReturnTrue_WhenLength8() {
        PasswordValidator pv = new PasswordValidator();
        assertTrue(pv.hasMinLength("12345678", 8));
    }

    @Test
    void hasMinLength_ShouldReturnTrue_WhenLength10() {
        PasswordValidator pv = new PasswordValidator();
        assertTrue(pv.hasMinLength("1234567890", 8));
    }

    @Test
    void hasMinLength_ShouldReturnFalse_WhenGivenNull() {
        PasswordValidator pv = new PasswordValidator();
        assertFalse(pv.hasMinLength(null, 8));
    }


    @Test
    void hasMinLength_ShouldReturnFalse_WhenGivenBlankSpacesExist() {
        PasswordValidator pv = new PasswordValidator();
        assertFalse(pv.hasMinLength(" 123 ", 5));
    }

    @Test
    void hasMinLength_ShouldReturnFalse_WhenLength0() {
        PasswordValidator pv = new PasswordValidator();
        assertFalse(pv.hasMinLength("", 8));
    }

    @Test
    void hasMinLength_ShouldReturnFalse_WhenMinIsZero() {
        PasswordValidator pv = new PasswordValidator();
        assertFalse(pv.hasMinLength("abc", 0));
    }

    @Test
    void hasMinLength_ShouldReturnFalse_WhenMinIsNegative() {
        PasswordValidator pv = new PasswordValidator();
        assertFalse(pv.hasMinLength("abc", -1));
    }

    @Test
    void hasMinLength_ShouldReturnFalse_ForVeryLongPassword() {
        PasswordValidator pv = new PasswordValidator();
        String longPassword = "a".repeat(1000);
        assertFalse(pv.hasMinLength(longPassword, 8));
    }


}