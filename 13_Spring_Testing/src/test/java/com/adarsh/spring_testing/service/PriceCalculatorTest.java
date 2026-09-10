package com.adarsh.spring_testing.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PriceCalculatorTest {

    private PriceCalculator priceCalculator;

    @BeforeEach
    void setup(){
         priceCalculator = new PriceCalculator();
    }

    @Test
    void shouldApplyDiscountToPrice(){

        // arrange --> Initial input
        double price = 1000;
        double discount = 20;

        // act --> Action performed
        double actualPrice =
                priceCalculator.calculatePrice(price, discount);

        // assertion  --> Expected Output
        assertEquals(800, actualPrice);
    }

    @Test
    void shouldRejectDiscountAboveHundred(){

        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> priceCalculator.calculatePrice(
                                1000,
                                120
                        )
                );
        assertEquals("Discount should be within 0 to 100",
                exception.getMessage());
    }
}
