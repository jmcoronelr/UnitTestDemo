package MembershipDiscount;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DiscountCalculatorTest {

    DiscountCalculator calculator = new DiscountCalculator();

    @Test
    void testNoMemberExactPurchase() {
        // Test an exact price for a non-member
        assertEquals(100.0, calculator.calculateFinalPrice(100.0, DiscountCalculator.MembershipLevel.NONE));
    }

    @Test
    void testNoMemberOverPurchase() {
        // Test a higher purchase for a non-member
        assertEquals(200.0, calculator.calculateFinalPrice(200.0, DiscountCalculator.MembershipLevel.NONE));
    }

    @Test
    void testNoMemberUnderPurchase() {
        // Test a lower purchase for a non-member
        assertEquals(50.0, calculator.calculateFinalPrice(50.0, DiscountCalculator.MembershipLevel.NONE));
    }

    @Test
    void testSilverMemberUnderLimit() {
        // Test a silver member with a purchase below the limit
        assertEquals(99.99, calculator.calculateFinalPrice(99.99, DiscountCalculator.MembershipLevel.SILVER));
    }

    @Test
    void testSilverMemberAtLimit() {
        // Test a silver member with a purchase exactly at the limit
        assertEquals(100, calculator.calculateFinalPrice(100.0, DiscountCalculator.MembershipLevel.SILVER));
    }

    @Test
    void testSilverMemberAboveLimit() {
        // Test a silver member with a purchase above the limit
        double expectedPrice = 95.95;
        double actualPrice = calculator.calculateFinalPrice(101.0, DiscountCalculator.MembershipLevel.SILVER);
        double delta = 0.01; // Tolerance of 0.01 for final comparison

        assertEquals(expectedPrice, actualPrice, delta);
    }


    @Test
    void testNegativePrice() {
        // Verify that an exception is thrown when entering a negative price
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateFinalPrice(-1.0, DiscountCalculator.MembershipLevel.NONE);
        });
        assertEquals("Original price cannot be negative.", exception.getMessage());
    }
    @Test
    void testGoldMemberUnderLimit() {
        // Test Gold member with a purchase below the limit
        assertEquals(49.0, calculator.calculateFinalPrice(49.0, DiscountCalculator.MembershipLevel.GOLD));
    }
    @Test
    void testGoldMemberAtLimit() {
        // Test Gold member with a purchase at the limit
        assertEquals(50,calculator.calculateFinalPrice(50, DiscountCalculator.MembershipLevel.GOLD));
    }
    @Test
    void testGoldMemberOverLimit() {
        // Test Gold member with a purchase over the limit
        assertEquals(45.9,calculator.calculateFinalPrice(51, DiscountCalculator.MembershipLevel.GOLD));
    }
    @Test
    void testPlatinumMemberRegularPurchase() {
        // Test Platinum member with a regular purchase
        assertEquals(80, calculator.calculateFinalPrice(100.0, DiscountCalculator.MembershipLevel.PLATINUM));
    }
}
