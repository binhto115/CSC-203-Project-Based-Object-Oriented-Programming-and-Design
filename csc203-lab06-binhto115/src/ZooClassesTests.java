import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ZooClassesTests {
    // Insert your tests below

    @Test
    void testZooSize() {
        Zoo zoo = new Zoo();
        Rabbit rabbit = new Rabbit();
        Monkey monkey = new Monkey();
        Cat cat = new Cat();
        zoo.addAnimal(rabbit);
        zoo.addAnimal(monkey);
        zoo.addAnimal(cat);
        ArrayList<Animal> animalList = zoo.getAnimals();
        assertEquals(animalList.size(), 3);
    }

    @Test
    void testRabbitClass() {
        Rabbit rabbit = new Rabbit();
        assertEquals(rabbit.getScientificName(), "HarleQuin");
        assertEquals(rabbit.move(), "hops");
        assertEquals(rabbit.vocalize(), "whines");
        assertEquals(rabbit.unique(), "Nickname: LittleBunny001");
    }

    @Test
    void testCatClass() {
        Cat cat = new Cat();
        assertEquals(cat.getScientificName(), "Siamese");
        assertEquals(cat.move(), "dashes");
        assertEquals(cat.vocalize(), "meows");
    }

    @Test
    void testMonkeyClass() {
        Monkey monkey = new Monkey();
        assertEquals(monkey.getScientificName(), "Capuchin");
        assertEquals(monkey.vocalize(), "squeaks");
        assertEquals(monkey.move(), "swings");
    }
    // Insert your tests above

    @Test
    void testAnimalConstructor() {
        try {
            Class<?> clazz = Class.forName("Animal");
            Constructor<?> constructor = clazz.getConstructor(String.class);
            assertNotNull(constructor);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            fail("Class not found: " + e.getMessage());
        }
    }

    @Test
    void testZooInitialization() {
        try {
            Class<?> clazz = Class.forName("Zoo");
            Constructor<?> constructor = clazz.getConstructor();
            Object obj = constructor.newInstance();
            assertNotNull(obj);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            fail("Class not found or cannot be instantiated: " + e.getMessage());
        }
    }
}
