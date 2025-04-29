import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BigNumberTests {
    // insert your tests below

    @Test
    void testAdditionOne() {
        Calculator testAdditionOne = new Calculator();
        assertEquals(testAdditionOne.additionOperator("1234", "1234"), "2468");
    }

    @Test
    void testAdditionTwo() {
        Calculator testAdditionTwo = new Calculator();
        assertEquals(testAdditionTwo.additionOperator("81", "6480"), "6561");
    }

    @Test
    void testAdditionThree() {
        Calculator testAdditionThree = new Calculator();
        assertEquals(testAdditionThree.additionOperator("393660", "6561"), "400221");
    }
    /*
    393660
      6561
    ------
    400221
    *
    * */
    @Test
    void testMultiplicationOne(){
        Calculator testMultiplicationOne = new Calculator();
        assertEquals(testMultiplicationOne.multiplicationOperator("12344", "2222"), "27428368");
    }

    @Test
    void testMultiplicationTwo(){
        Calculator testMultiplicationTwo = new Calculator();
        assertEquals(testMultiplicationTwo.multiplicationOperator("2222", "12344"), "27428368");
    }

    @Test
    void testMultiplicationThree(){
        Calculator testMultiplicationThree = new Calculator();
        assertEquals(testMultiplicationThree.multiplicationOperator("345", "33"), "11385");
    }

    @Test
    void testMultiplicationFour(){
        Calculator testMultiplicationFour = new Calculator();
        assertEquals(testMultiplicationFour.multiplicationOperator("33", "345"), "11385");
    }

    @Test
    void testMultiplicationFive(){
        Calculator testMultiplicationFive = new Calculator();
        assertEquals(testMultiplicationFive.multiplicationOperator("4543", "534"), "2425962");
    }

    @Test
    void testMultiplicationSix(){
        Calculator testMultiplicationSix = new Calculator();
        assertEquals(testMultiplicationSix.multiplicationOperator("534", "4543"), "2425962");
    }

    @Test
    void testMultiplicationSeven(){
        Calculator testMultiplicationSeven = new Calculator();
        String str1 = "12341";
        String str2 = "4321";
        assertEquals(testMultiplicationSeven.multiplicationOperator(str1, str2), "53325461");
    }

    @Test
    void testMultiplicationEight(){
        Calculator testMultiplicationEight = new Calculator();
        assertEquals(testMultiplicationEight.multiplicationOperator("4321", "12341"), "53325461");
    }

    @Test
    void testMultiplicationNine(){
        Calculator testMultiplicationNine = new Calculator();
        assertEquals(testMultiplicationNine.multiplicationOperator("22", "22"), "484");
    }

    @Test
    void testMultiplicationTen(){
        Calculator testMultiplicationTen = new Calculator();
        assertEquals(testMultiplicationTen.multiplicationOperator("1234", "6548"), "8080232");
    }

    @Test
    void testMultiplicationEleven(){
        Calculator testMultiplicationEleven = new Calculator();
        assertEquals(testMultiplicationEleven.multiplicationOperator("22", "55"), "1210");
    }

    @Test
    void testMultiplicationTwelve(){
        Calculator testMultiplicationTwelve = new Calculator();
        assertEquals(testMultiplicationTwelve.multiplicationOperator("3214", "9786"), "31452204");
    }

    @Test
    void testMultiplicationThirteenth(){
        Calculator testMultiplicationThirteenth = new Calculator();
        assertEquals(testMultiplicationThirteenth.multiplicationOperator("81", "81"), "6561");
    }

    @Test
    void testMultiplication14th(){
        Calculator testMultiplication14th = new Calculator();
        assertEquals(testMultiplication14th.multiplicationOperator("6561", "6561"), "43046721");
    }

    /*6561
    * 6561
    * ----
    * 6561
    393660
   3280500
  39366000
  --------
  43046721
  *  */
    @Test
    void testExponentiationOne() {
        Calculator testExponentiationOne = new Calculator();
        assertEquals(testExponentiationOne.exponentiationOperator("2", "2"), "4");
    }

    @Test
    void testExponentiationTwo() {
        Calculator testExponentiationTwo = new Calculator();
        assertEquals(testExponentiationTwo.exponentiationOperator("3", "50"), "717897987691852588770249");
    }

    @Test
    void testExponentiationThree() {
        Calculator testExponentiationThree = new Calculator();
        assertEquals(testExponentiationThree.exponentiationOperator("3", "0"), "1");
    }

    @Test
    void testExponentiationFour() {
        Calculator testExponentiationFour = new Calculator();
        assertEquals(testExponentiationFour.exponentiationOperator("3", "1"), "3");
    }
}

