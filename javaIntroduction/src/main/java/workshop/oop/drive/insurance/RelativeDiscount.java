package workshop.oop.drive.insurance;

public class RelativeDiscount implements Discounts {
    private final int relativeDiscountPercentage;

    public RelativeDiscount(final int percentage) {
        this.relativeDiscountPercentage = percentage;
    }

    @Override
    public int calculateDiscount(int actualPrice) {
        return actualPrice * this.relativeDiscountPercentage / 100;
    }
}
