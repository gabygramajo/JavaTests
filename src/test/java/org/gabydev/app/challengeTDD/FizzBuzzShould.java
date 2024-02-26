package org.gabydev.app.challengeTDD;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzShould {
    /*
    * Si el número es divisible por 3, retorna “Fizz”
    * Si el número es divisible por 5, retorna “Buzz”
    * Si el número es divisible por 3 y por 5, retorna “FizzBuzz”
    * En otro caso, retorna el mismo número
    * */

    @Test
    public void return_fizz_when_is_divisible_by_3() {
        assertThat(FizzBuzz.fizzBuzz(9), CoreMatchers.is("Fizz"));
        assertThat(FizzBuzz.fizzBuzz(24), CoreMatchers.is("Fizz"));
        assertThat(FizzBuzz.fizzBuzz(69), CoreMatchers.is("Fizz"));
        assertThat(FizzBuzz.fizzBuzz(108), CoreMatchers.is("Fizz"));
    }

    @Test
    public void return_buzz_when_is_divisible_by_5() {
        assertThat(FizzBuzz.fizzBuzz(10), CoreMatchers.is("Buzz"));
        assertThat(FizzBuzz.fizzBuzz(20), CoreMatchers.is("Buzz"));
        assertThat(FizzBuzz.fizzBuzz(25), CoreMatchers.is("Buzz"));
        assertThat(FizzBuzz.fizzBuzz(40), CoreMatchers.is("Buzz"));
    }

    @Test
    public void return_fizzbuzz_when_is_divisible_by_3_and_5() {
        assertThat(FizzBuzz.fizzBuzz(15), CoreMatchers.is("FizzBuzz"));
        assertThat(FizzBuzz.fizzBuzz(30), CoreMatchers.is("FizzBuzz"));
        assertThat(FizzBuzz.fizzBuzz(45), CoreMatchers.is("FizzBuzz"));
        assertThat(FizzBuzz.fizzBuzz(90), CoreMatchers.is("FizzBuzz"));
    }

    @Test
    public void return_number_when_not_divisible_by_3_or_5() {
        assertThat(FizzBuzz.fizzBuzz(14), CoreMatchers.is("14"));
        assertThat(FizzBuzz.fizzBuzz(29), CoreMatchers.is("29"));
        assertThat(FizzBuzz.fizzBuzz(199), CoreMatchers.is("199"));
        assertThat(FizzBuzz.fizzBuzz(502), CoreMatchers.is("502"));
    }

    @Test
    public void validate_all_cases() {
        assertThat(FizzBuzz.fizzBuzz(3), CoreMatchers.is("Fizz"));
        assertThat(FizzBuzz.fizzBuzz(6), CoreMatchers.is("Fizz"));
        assertThat(FizzBuzz.fizzBuzz(5), CoreMatchers.is("Buzz"));
        assertThat(FizzBuzz.fizzBuzz(10), CoreMatchers.is("Buzz"));
        assertThat(FizzBuzz.fizzBuzz(30), CoreMatchers.is("FizzBuzz"));
        assertThat(FizzBuzz.fizzBuzz(2), CoreMatchers.is("2"));
        assertThat(FizzBuzz.fizzBuzz(16), CoreMatchers.is("16"));
    }
}