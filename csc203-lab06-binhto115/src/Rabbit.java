public class Rabbit extends Animal {
    public Rabbit() {
        super("HarleQuin");
    }

    public String vocalize() {return "whines";}

    public String move() {return "hops";}

    public String unique() {return "Nickname: LittleBunny001";}

    public static void listFiltered(Zoo zoo) {
        for (Animal animal: zoo.getAnimals()) {
            if (animal instanceof Rabbit) {
                System.out.print(((Rabbit) animal).unique());
            }
        }
    }
}
