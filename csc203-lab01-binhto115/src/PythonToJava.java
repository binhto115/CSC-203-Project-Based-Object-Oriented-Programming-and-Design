import java.util.ArrayList;
import java.util.List;

class PythonToJava{
    public static int count(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c)
                count += 1;
        }
        return count;
    }
    public static void main(String[] args) {
        // Numerics
        int x = 2;
        double y = 4.0;
        System.out.println(Math.pow(x, y));

        // Fixed size list
        int[] intArray = {1, 2, 3, 4};
        for (int i : intArray) {
            System.out.print(i + " ");
        }

        // String
        String s = "mochimochimochi";
        int num = count(s,'o');
        System.out.print("\n" + num);

        // Variable sized list
        List<Double> list = new ArrayList<>(x);
        list.add(1.2);
        list.add(3.4);
        list.add(5.6);
        for (double i : list) {
            System.out.print("\n" + i);
        }
    }
}