package com.example;

public abstract class AbstractPasswordValidator {

    public abstract boolean hasMinLength(String password, int min);

    public abstract boolean containsDigit(String password);

    public abstract boolean containsUpperAndLower(String password);

    public abstract boolean isCommonPassword(String password);

    public abstract boolean containsSpecialChar(String password, String allowed);

    public abstract boolean isValid(String password);

}
