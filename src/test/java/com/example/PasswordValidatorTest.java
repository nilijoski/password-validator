package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    private PasswordValidator passwordValidator;
    private static final String SPECIALCHARS = "!@#$%^&*()-_+=?.,;:";

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

    @Test
    void containsUpperAndLower_ShouldReturnFalse_WhenOnlyUppercase() {
        assertFalse(passwordValidator.containsUpperAndLower("ABCDEF"));
    }

    @Test
    void containsUpperAndLower_ShouldReturnFalse_WhenOnlyLowercase() {
        assertFalse(passwordValidator.containsUpperAndLower("abcdef"));
    }

    @Test
    void containsUpperAndLower_ShouldReturnTrue_WhenMixedCase() {
        assertTrue(passwordValidator.containsUpperAndLower("AbCdEf"));
    }

    @Test
    void containsUpperAndLower_ShouldReturnFalse_WhenSingleLetterUppercase() {
        assertFalse(passwordValidator.containsUpperAndLower("A"));
    }

    @Test
    void containsUpperAndLower_ShouldReturnFalse_WhenSingleLetterLowercase() {
        assertFalse(passwordValidator.containsUpperAndLower("a"));
    }

    @Test
    void containsUpperAndLower_ShouldReturnFalse_WhenNull() {
        assertFalse(passwordValidator.containsUpperAndLower(null));
    }

    @Test
    void containsUpperAndLower_ShouldReturnFalse_WhenEmpty() {
        assertFalse(passwordValidator.containsUpperAndLower(""));
    }

    @Test
    void isCommonPassword_ShouldReturnTrue_WhenPasswordIsInList_Lowercase() {
        assertTrue(passwordValidator.isCommonPassword("password"));
    }

    @Test
    void isCommonPassword_ShouldReturnTrue_WhenPasswordIsInList_MixedCase() {
        assertTrue(passwordValidator.isCommonPassword("PassWord")); // case-insensitive
    }

    @Test
    void isCommonPassword_ShouldReturnTrue_WhenPasswordIsInList_WithNumber() {
        assertTrue(passwordValidator.isCommonPassword("Password1"));
    }

    @Test
    void isCommonPassword_ShouldReturnTrue_WhenPasswordIsInList_AllDigits() {
        assertTrue(passwordValidator.isCommonPassword("12345678"));
    }

    @Test
    void isCommonPassword_ShouldReturnTrue_WhenPasswordIsInList_ComplexExample() {
        assertTrue(passwordValidator.isCommonPassword("Aa345678"));
    }

    @Test
    void isCommonPassword_ShouldReturnFalse_WhenPasswordIsNotInList() {
        assertFalse(passwordValidator.isCommonPassword("SecurePa55"));
    }

    @Test
    void isCommonPassword_ShouldReturnFalse_WhenNull() {
        assertFalse(passwordValidator.isCommonPassword(null));
    }

    @Test
    void isCommonPassword_ShouldReturnFalse_WhenEmpty() {
        assertFalse(passwordValidator.isCommonPassword(""));
    }

    @Test
    void isValid_ShouldReturnTrue_WhenAllMustCriteriaMet() {
        assertTrue(passwordValidator.isValid("Abcd1234"));
    }

    @Test
    void isValid_ShouldReturnTrue_WhenLongerAndMeetsAllCriteria() {
        assertTrue(passwordValidator.isValid("StrongPass99"));
    }

    @Test
    void isValid_ShouldReturnFalse_WhenTooShort() {
        assertFalse(passwordValidator.isValid("Ab1cdef")); // 7 Zeichen
    }

    @Test
    void isValid_ShouldReturnFalse_WhenNoDigit() {
        assertFalse(passwordValidator.isValid("Abcdefgh"));
    }

    @Test
    void isValid_ShouldReturnFalse_WhenOnlyUppercase() {
        assertFalse(passwordValidator.isValid("ABCDEFG1"));
    }

    @Test
    void isValid_ShouldReturnFalse_WhenOnlyLowercase() {
        assertFalse(passwordValidator.isValid("abcdefg1"));
    }

    @Test
    void isValid_ShouldReturnFalse_WhenCommonPasswordEvenIfCriteriaLookOk() {
        assertFalse(passwordValidator.isValid("Aa345678"));
    }

    @Test
    void isValid_ShouldReturnFalse_WhenNullOrEmpty() {
        assertFalse(passwordValidator.isValid(null));
        assertFalse(passwordValidator.isValid(""));
    }

    @Test
    void containsSpecialChar_ShouldReturnTrue_WhenExactlyOneAllowedChar() {
        assertTrue(passwordValidator.containsSpecialChar("Abcdef!", SPECIALCHARS));
    }

    @Test
    void containsSpecialChar_ShouldReturnTrue_WhenMultipleAllowedChars() {
        assertTrue(passwordValidator.containsSpecialChar("A?bc;d:f", SPECIALCHARS));
    }

    @Test
    void containsSpecialChar_ShouldReturnFalse_WhenNoAllowedCharPresent() {
        assertFalse(passwordValidator.containsSpecialChar("Abcd1234", SPECIALCHARS));
    }

    @Test
    void containsSpecialChar_ShouldReturnFalse_WhenPasswordIsNullOrEmpty() {
        assertFalse(passwordValidator.containsSpecialChar(null, SPECIALCHARS));
        assertFalse(passwordValidator.containsSpecialChar("", SPECIALCHARS));
    }

    @Test
    void containsSpecialChar_ShouldReturnFalse_WhenAllowedSetIsEmptyOrNull() {
        assertFalse(passwordValidator.containsSpecialChar("Abc!", ""));
        assertFalse(passwordValidator.containsSpecialChar("Abc!", null));
    }

    @Test
    void containsSpecialChar_ShouldReturnFalse_WhenOnlyNonSPECIALCHARSSymbols() {
        assertFalse(passwordValidator.containsSpecialChar("Abc€", SPECIALCHARS));
    }

    @ParameterizedTest(name = "[{index}] valid password → {0}")
    @CsvSource({
            "Abcd1234?, true",
            "Strong!Pass99, true",
            "MyP@ssw0rd, true",
            "Zz9!yYyYyY, true"
    })
    void isValid_shouldReturnTrue_ForValidPasswords(String password, boolean expected) {
        assertEquals(expected, passwordValidator.isValid(password, SPECIALCHARS));
    }

    @ParameterizedTest(name = "[{index}] invalid password → {0}")
    @CsvSource({
            "Ab1cdef, false",
            "Abcdefgh, false",
            "abcdefg1, false",
            "ABCDEFG1, false",
            "Aa345678, false",
            "Abcdefg١, false",
            "'', false"
    })
    void isValid_shouldReturnFalse_ForInvalidPasswords(String password, boolean expected) {
        assertEquals(expected, passwordValidator.isValid(password, SPECIALCHARS));
    }

}