import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScreenClassesTests {
    // Insert your tests below

    // Insert your tests above
    
    @Test
    void testScreenInitialization() {
        try {
            Class<?> clazz = Class.forName("Screen");
            Constructor<?> constructor = clazz.getConstructor(double.class, double.class, int.class, boolean.class);
            Object obj = constructor.newInstance(1.0, 1.0, 1, true);
            assertNotNull(obj);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            fail("Class not found or cannot be instantiated: " + e.getMessage());
        }
    }

    @Test
    void testSmartPhoneInitialization() {
        try {
            Class<?> clazz = Class.forName("SmartPhone");
            Constructor<?> constructor = clazz.getConstructor(String.class, double.class, double.class, int.class, boolean.class);
            Object obj = constructor.newInstance("android", 1.0, 1.0, 1, true);
            assertNotNull(obj);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            fail("Class not found or cannot be instantiated: " + e.getMessage());
        }
    }

    @Test
    void testSetIsOn() {
        Screen testScreenOne = new Screen(3.5, 6.8, 1000, true);
        testScreenOne.setIsOn(true);
        assertTrue(testScreenOne.getIsOn());
    }

    @Test
    void testSetIsOnTwo() {
        Screen testScreenTwo = new Screen(4.5, 7.8, 2000, true);
        testScreenTwo.setIsOn(false);
        assertFalse(testScreenTwo.getIsOn());
    }

    @Test
    void testGetIsOnScreen() {
        Screen testGetIsOnOne = new Screen(4.5, 7.8, 2000, true);
        assertTrue(testGetIsOnOne.getIsOn());
    }

    @Test
    void testGetIsOnScreenTwo() {
        Screen testGetIsOnTwo = new Screen(4.5, 7.8, 2000, false);
        assertFalse(testGetIsOnTwo.getIsOn());
    }
    @Test
    void testDisplayOne() {
        Screen testDisplayOne = new Screen(4.5, 7.8, 3000, true);
        String testDisplayString = "The Number of Screen Pixels is 3.159E8";
        assertEquals(testDisplayOne.display(), testDisplayString);
    }

    @Test
    void testDisplayTwo() {
        Screen testDisplayTwo = new Screen(5.0, 10.0, 1000, true);
        String testDisplayStringTwo = "The Number of Screen Pixels is 5.0E7";
        assertEquals(testDisplayTwo.display(), testDisplayStringTwo);
    }

    @Test
    void testDisplayThree() {
        Screen testDisplayThree = new Screen(5.0, 10.0, 1000, false);
        assertNull(testDisplayThree.display());
    }

    @Test
    void testNumberOfPixels() {
        Screen testNumberOfPixels = new Screen(6.9,8.9, 10000, true);
        assertEquals(testNumberOfPixels.numberOfPixels(), 6.141E9);
    }
    @Test
    void testCall() {
        SmartPhone testSmartPhone = new SmartPhone("ios", 4.7, 6.8, 9999, true);
        assertEquals(testSmartPhone.call(), "ringringring");
    }

    @Test
    void testCallTwo() {
        SmartPhone testSmartPhoneTwo = new SmartPhone("ios", 4.7, 6.8, 9999, false);
        assertNull(testSmartPhoneTwo.call());
    }

    @Test
    void testDisplaySPOne() {
        SmartPhone  orDisplay = new SmartPhone("Android", 4.6, 7.0, 1000, true);
        assertEquals(orDisplay.display(), "Android");
    }

    @Test
    void testDisplaySPTwo() {
        SmartPhone  orDisplayTwo = new SmartPhone("Android", 4.6, 7.0, 1000, false);
        assertNull(orDisplayTwo.display());
    }
}