import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor {
    /**
     * Processes arithmetic expressions line-by-line in the given file.
     *
     * @param filePath Path to a file containing arithmetic expressions.
     */
    public static void processFile(String filePath) {
        File infile = new File(filePath);
        try (Scanner scan = new Scanner(infile)) {
            while (scan.hasNext()) {
                String line = scan.nextLine();
                // Split line into an array of strings;
                String[] parseString = line.split("\\s+");
                // Assigning integer variables indexed elements and perform calculations
                if (parseString.length != 3) {continue;}
                String firstString = parseString[0];
                String secondString = parseString[2];
                String operator = parseString[1];
                String calculation = "";
                Calculator calculator = new Calculator();
                switch (operator) {
                    case "+":
                        calculation = calculator.additionOperator(firstString, secondString);
                        break;
                    case "*":
                        calculation = calculator.multiplicationOperator(firstString, secondString);
                        break;
                    case "^":
                        calculation = calculator.exponentiationOperator(firstString, secondString);
                        break;
                }
                line = firstString + " " + operator + " " + secondString + " = " + calculation;
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }
}