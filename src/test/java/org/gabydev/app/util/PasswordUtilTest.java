package org.gabydev.app.util;

import org.junit.Test;

import static org.gabydev.app.util.PasswordUtil.SecurityLevel.*;
import static org.junit.Assert.*;

public class PasswordUtilTest {

    @Test
    public void weakWhenHasLessThan8Letters() {

        assertEquals(
                WEAK,
                PasswordUtil.assessPassword("12a#")
        );

    }

    @Test
    public void weakWhenHasLessThanOnlyLetters() {

        assertEquals(
                WEAK,
                PasswordUtil.assessPassword("asdasdsdfss")
        );

    }

    @Test
    public void mediumWhenHasLessThanLettersAndNumbers() {

        assertEquals(
                MEDIUM,
                PasswordUtil.assessPassword("abcdqq1234")
        );

    }

    @Test
    public void strongWhenHasLessThanLettersNumbersAndSymbols() {

        assertEquals(
                STRONG,
                PasswordUtil.assessPassword("abcd1234!")
        );

    }
}