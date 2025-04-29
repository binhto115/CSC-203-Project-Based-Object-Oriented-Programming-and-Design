import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SpaghettiTests {
    // Insert your tests below
    @Test
    void testStringify() {
        Spaghetti sTest = new Spaghetti(2.0, "Soy sauce");
        String testString = "2.0, Soy sauce";
        assertEquals(testString, sTest.stringify());
    }

    @Test
    void testToString() {
        Spaghetti sTest_2 = new Spaghetti(5.0, "Marinara sauce");
        String testString_2 = "5.0, Marinara sauce";
        assertEquals(testString_2, sTest_2.toString());
    }

    @Test
    void testEquals() {
        Spaghetti spaghettiDishOne = new Spaghetti(1.0, "Tomato sauce");
        Spaghetti spaghettiDishTwo = new Spaghetti(1.0, "Tomato sauce");
        Spaghetti spaghettiDishThree = new Spaghetti(2.0, "Afredo sauce");
        Spaghetti spaghettiDishFour = new Spaghetti(3.0, "Carbonara sauce");
        assertTrue(spaghettiDishOne.equals(spaghettiDishTwo));
        assertTrue(spaghettiDishOne.equals(spaghettiDishOne));
        assertFalse(spaghettiDishOne.equals(spaghettiDishThree));
        assertFalse(spaghettiDishThree.equals(spaghettiDishFour));
    }

    @Test
    void testHashCode() {
        Spaghetti spaghettiDishOne = new Spaghetti(1.0, "Tomato sauce");
        Spaghetti spaghettiDishTwo = new Spaghetti(1.0, "Tomato sauce");
        Spaghetti spaghettiDishThree = new Spaghetti(2.0, "Afredo sauce");
        Spaghetti spaghettiDishFour = new Spaghetti(3.0, "Carbonara sauce");
        assertEquals(spaghettiDishOne.hashCode(), spaghettiDishTwo.hashCode());
        assertNotEquals(spaghettiDishOne.hashCode(), spaghettiDishThree.hashCode());
        assertNotEquals(spaghettiDishFour.hashCode(), spaghettiDishThree.hashCode());
    }
    // Insert your tests above

    @Test
    void testSpaghettiInstantiation() {
        try {
            Class<?> clazz = Class.forName("Spaghetti");
            Constructor<?> constructor = clazz.getConstructor(double.class, String.class);
            Object obj = constructor.newInstance(1, "");
            assertNotNull(obj);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            fail("Class not found or cannot be instantiated: " + e.getClass());
        }
    }
}