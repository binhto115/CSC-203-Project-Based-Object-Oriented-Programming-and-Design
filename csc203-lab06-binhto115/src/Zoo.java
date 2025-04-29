import java.util.ArrayList;

public class Zoo {
    private final ArrayList<Animal> animals;

    public Zoo(){
        this.animals = new ArrayList<Animal>();
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void listAnimal() {
        for (Animal animal: animals) {
            System.out.println(animal.getScientificName() + animal.vocalize() + animal.move());
        }
    }
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        Monkey monkey = new Monkey();
        Cat cat = new Cat();
        Rabbit rabbit = new Rabbit();
        zoo.addAnimal(monkey);
        zoo.addAnimal(cat);
        zoo.addAnimal(rabbit);

        zoo.listAnimal();

        // Unique
        Rabbit.listFiltered(zoo);
    }
}
