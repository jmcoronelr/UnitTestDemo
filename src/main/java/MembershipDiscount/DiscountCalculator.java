package MembershipDiscount;

public class DiscountCalculator {
    public enum MembershipLevel {        NONE, SILVER, GOLD, PLATINUM    }
    public double calculateFinalPrice(double originalPrice, MembershipLevel membership) {
        if (membership == MembershipLevel.NONE)
        {            return originalPrice;        }
        else if (membership == MembershipLevel.SILVER && originalPrice > 100)
        {            return originalPrice * 0.95;} // 5% discount
        else if (membership == MembershipLevel.GOLD && originalPrice > 50)
        {            return originalPrice * 0.90;} // 10% discount
        else if (membership == MembershipLevel.PLATINUM)
        {            return originalPrice * 0.80;} // 20% discount
        else {
            return originalPrice;} // No discount for smaller amounts
        }
    }
