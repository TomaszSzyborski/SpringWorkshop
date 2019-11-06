package workshop.oop.drive.insurance;

public class OCInsurance {
    private Sex sex;
    private final int initialPrice;
    private int yearlyPrice = 0;
    private int absoluteDiscount = 0;
    private int relativeDiscount = 0;
    private int vipDiscount = 0;
    private int sexDiscount= 0;

    public OCInsurance(int initialPrice) {
        this.initialPrice = initialPrice;
        this.yearlyPrice = initialPrice;
    }

    public OCInsurance(Sex sex, int initialPrice) {
        this.initialPrice = initialPrice;
        this.sex = sex;
        this.yearlyPrice = initialPrice;
    }

    public int calculateFinalPrice() {
        int priceAfterAbsoluteDiscount = yearlyPrice - absoluteDiscount;
        int priceAfterRelativeDiscount = priceAfterAbsoluteDiscount * relativeDiscount / 100;
        int beforeSexDiscount = priceAfterAbsoluteDiscount - priceAfterRelativeDiscount - vipDiscount;
        return beforeSexDiscount - sexDiscount * beforeSexDiscount / 100;
    }

    public void addAbsoluteDiscount(int i) {
        if (initialPrice - i > 0) {
            this.absoluteDiscount += i;
        }

    }

    public void addRelativeDiscount(int i) {
        this.relativeDiscount = i;
    }

    public void removeAbsoluteDiscounts() {
        this.absoluteDiscount = 0;
    }

    public void addVIPDiscount(int i) {
        if (initialPrice > 5000) {
            vipDiscount = (initialPrice - absoluteDiscount) * i / 100;
        }
    }

    public void addSexDiscount(Sex sex, int amount) {
        if (this.sex.equals(sex)){
            sexDiscount = amount;
        }
    }
}
