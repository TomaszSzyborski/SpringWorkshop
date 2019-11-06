package workshop.oop.list;

public class Sheep extends Animal implements WoolProvider, MeatProvider, Eater<Grass>{

    // owca moze byc dostarczycielem miesa, mleka etc/
    // owca moze byc zwierzeciem

    String name;
    String name2;
//  public Sheep(String beee) {
//    final Wool wool = new Wool(){
//      @Override
//      public void dosth() {
//        System.out.println("I am null");
//      }
//    };
//  }

    public Sheep(String beee) {
        super("Baaaaaaasia");
        final Wool wool = (int i) -> System.out.println("I am null");
    }

    public Sheep() {
        super("blblblbllbl");
    }
//klasa wewnętrzna
//  class Wool{
//    void dosth(){
//
//    }
//  }
    public void doSth(String name){
        super.name = name;
    }

    @Override
    public int getSomeMeat() {
        return 0;
    }

    @Override
    public Wool getSomeWool() {
        return null;
    }

    @Override
    public int getPerformance() {
        return WoolProvider.super.getPerformance();
    }

    @Override
    public void eat(final Grass grass) {
        if (!grass.isMyFavourite()){
            new RuntimeException("puke!!!");
        }
        if(grass.getAmount() > 100){
            new RuntimeException("puke!!!");
        }
        return;
    }

    @FunctionalInterface
    interface Wool {
        void dosth(int i);
    }

    public static void main() {
        final Sheep sheep = new Sheep("bee");
//        try {
//            sheep.getClass().getField("name2").set("name2", "lololol");
//        } catch (IllegalAccessException | NoSuchFieldException e) {
//            e.printStackTrace();
//        }
        sheep.eat(new Grass(3));
//    final Sheep sheep = new Sheep("bee");
//    final Wool wool = sheep.new Wool();
    }
}
