package workshop.oop.drive.insurance;

public interface Discounts {
    int calculateDiscount(int amount, final Sex sex);
    default boolean isAbsoluteDiscount(){
        return false;
    }
}
