package org.gabydev.app.util;

public class PasswordUtil {

    public enum SecurityLevel {
        WEAK, MEDIUM, STRONG
    }

    public static SecurityLevel assessPassword(String password) {

        if (password.length() < 8)
            return SecurityLevel.WEAK;

        // pass con solo letras [a-zA-Z] varias veces +
        if(password.matches("[a-zA-Z]+"))
            return SecurityLevel.WEAK;

        // pass con letras y numeros [a-zA-Z0-9] varias veces +
        if(password.matches("[a-zA-Z0-9]+"))
            return SecurityLevel.MEDIUM;

        return SecurityLevel.STRONG;
    }
}
