package workshop.oop.drive.insurance;

public class VipDiscount implements Discounts {
    private final int relativeDiscountPercentage;

    public VipDiscount(final int percentage) {
        this.relativeDiscountPercentage = percentage;
    }

    @Override
    public int calculateDiscount(int actualPrice) {
        return actualPrice * this.relativeDiscountPercentage / 100;
    }
}
