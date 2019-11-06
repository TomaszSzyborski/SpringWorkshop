package workshop.oop.drive.insurance;

public class SexDiscount implements Discounts {
    private final int sexDiscountAmount;

    public SexDiscount(final int price) {
        this.sexDiscountAmount = price;
    }

    @Override
    public int calculateDiscount(int actualPrice, Sex sex) {
        return actualPrice * sexDiscountAmount/100;
    }
}
