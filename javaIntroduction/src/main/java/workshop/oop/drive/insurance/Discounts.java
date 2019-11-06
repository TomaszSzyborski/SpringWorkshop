package workshop.oop.drive.insurance;

public interface Discounts {
    int calculateDiscount(int amount);
    default boolean isAbsoluteDiscount(){
        return false;
    }
}
