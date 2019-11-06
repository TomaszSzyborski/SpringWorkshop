package workshop.oop.drive.insurance;

public class SexDiscount implements Discounts {
    private final int sexDiscountAmount;

    public SexDiscount(final int price) {
        this.sexDiscountAmount = price;
    }

    @Override
    public int calculateDiscount(int actualPrice) {
        return actualPrice * sexDiscountAmount/100;
    }
}
