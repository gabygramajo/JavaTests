package org.gabydev.app.discounts;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class PriceCalculatorShould {

    @Test
    public void total_zero_whe_there_not_prices() {
        PriceCalculator calculator = new PriceCalculator();

        assertThat(calculator.getTotal(), CoreMatchers.is(0.0));
    }

    @Test
    public void total_is_sum_of_prices() {
        PriceCalculator calculator = new PriceCalculator();

        calculator.addPrice(10.2);
        calculator.addPrice(15.5);

        assertThat(calculator.getTotal(), CoreMatchers.is(25.7));
    }

    @Test
    public void apply_discount_to_prices() {
        PriceCalculator calculator = new PriceCalculator();

        calculator.addPrice(100);
        calculator.addPrice(50);
        calculator.addPrice(50);

        calculator.setDiscount(25);

        assertThat(calculator.getTotal(), CoreMatchers.is(150.0));
    }
}