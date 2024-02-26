package org.gabydev.app.challengeTDD;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class RomanNumeralShould {

    @Test
    public void return_roman_numeral_when_arabic_numeral_input() {
        assertThat(RomanNumeral.arabicToRoman(1), is("I"));
        assertThat(RomanNumeral.arabicToRoman(3), is("III"));
        assertThat(RomanNumeral.arabicToRoman(4), is("IV"));
        assertThat(RomanNumeral.arabicToRoman(5), is("V"));
        assertThat(RomanNumeral.arabicToRoman(7), is("VII"));
        assertThat(RomanNumeral.arabicToRoman(9), is("IX"));
        assertThat(RomanNumeral.arabicToRoman(10), is("X"));

        assertThat(RomanNumeral.arabicToRoman(11),is("XI"));
        assertThat(RomanNumeral.arabicToRoman(15),is("XV"));
        assertThat(RomanNumeral.arabicToRoman(16),is("XVI"));
        assertThat(RomanNumeral.arabicToRoman(50),is("L"));
        assertThat(RomanNumeral.arabicToRoman(51),is("LI"));
        assertThat(RomanNumeral.arabicToRoman(55),is("LV"));
        assertThat(RomanNumeral.arabicToRoman(56),is("LVI"));
        assertThat(RomanNumeral.arabicToRoman(60),is("LX"));
        assertThat(RomanNumeral.arabicToRoman(70),is("LXX"));
        assertThat(RomanNumeral.arabicToRoman(80),is("LXXX"));
        assertThat(RomanNumeral.arabicToRoman(81),is("LXXXI"));
        assertThat(RomanNumeral.arabicToRoman(85),is("LXXXV"));
        assertThat(RomanNumeral.arabicToRoman(86),is("LXXXVI"));
        assertThat(RomanNumeral.arabicToRoman(126),is("CXXVI"));
        assertThat(RomanNumeral.arabicToRoman(2507),is("MMDVII"));
    }

}