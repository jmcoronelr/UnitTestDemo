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
        assertEquals(95.0, calculator.calculateFinalPrice(100.0, DiscountCalculator.MembershipLevel.SILVER));
    }

    @Test
    void testSilverMemberAboveLimit() {
        // Test a silver member with a purchase above the limit
        assertEquals(95.95, calculator.calculateFinalPrice(101.0, DiscountCalculator.MembershipLevel.SILVER));
    }

    @Test
    void testNegativePrice() {
        // Verify that an exception is thrown when entering a negative price
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateFinalPrice(-1.0, DiscountCalculator.MembershipLevel.NONE);
        });
        assertEquals("Original price cannot be negative.", exception.getMessage());
    }
}
