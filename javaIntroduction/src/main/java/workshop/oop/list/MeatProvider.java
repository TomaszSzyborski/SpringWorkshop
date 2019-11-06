package workshop.oop.list;

public interface MeatProvider {
    int getSomeMeat();
    default int getPerformance(){
        return 5;
    }
}
