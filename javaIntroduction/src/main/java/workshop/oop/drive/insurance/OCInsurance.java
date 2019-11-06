package workshop.oop.drive.insurance;

import java.util.LinkedList;

public class OCInsurance {
    private Sex sex;
    private final int initialPrice;
    private LinkedList<Discounts> discounts = new LinkedList<>();
    private int actualPrice;
    public OCInsurance(int initialPrice) {
        this.initialPrice = initialPrice;
    }

    public OCInsurance(Sex sex, int initialPrice) {
        this.initialPrice = initialPrice;
        this.sex = sex;
    }



    public int calculateFinalPrice() {
        actualPrice = initialPrice;
        for(Discounts discount: discounts){
            actualPrice -= discount.calculateDiscount(actualPrice, sex);
        }
        return  actualPrice;
    }

    public void addAbsoluteDiscount(int i) {
        if (initialPrice - i > 0) {
            discounts.add(new AbsoluteDiscount(i));
        }

    }

    public void addRelativeDiscount(int i) {
        discounts.add(new RelativeDiscount(i));
    }

    public void removeAbsoluteDiscounts() {
        discounts.removeIf(Discounts::isAbsoluteDiscount);
    }

    public void addVIPDiscount(int i) {
        if (initialPrice > 5000) {
            discounts.add(new VipDiscount(i));
        }
    }

    public void addSexDiscount(Sex sex, int amount) {
        if (this.sex.equals(sex)){
            discounts.add(new SexDiscount(amount));
        }
    }
}
