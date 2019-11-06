package workshop.oop.drive.insurance;

public class AbsoluteDiscount implements Discounts {
    private final int absoluteDiscountPrice;

    public AbsoluteDiscount(final int price) {
        this.absoluteDiscountPrice = price;
    }

    @Override
    public int calculateDiscount(int actualPrice, Sex sex) {
        return absoluteDiscountPrice;
    }

    @Override
    public boolean isAbsoluteDiscount() {
        return true;
    }
}
