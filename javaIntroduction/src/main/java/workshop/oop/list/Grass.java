package workshop.oop.list;

public class Grass implements Eatable{
    private int amount;
    private  boolean fav = true;
    public Grass(int amount) {
        this.amount = amount;
    }


    public int getAmount() {
        return amount;
    }

    public boolean isMyFavourite() {
    return fav;
    }
}
