import java.util.Scanner;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Locale;
import java.text.NumberFormat;
import java.text.ParseException;
import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.Currency;


/*
 * SE 320 - Software Construction 
 * Author: Jonathan Legro
 * Date: October 24, 2024
 * Homework Assignment: Four
 * Description: 
    1. Create two linked hash sets {"George", "Jim", "John", "Blake", "Kevin", "Michael"} 
    and {"George", "Katie", "Kevin", "Michelle", "Ryan"} and find their union, difference, and intersection. 
    (You can clone the sets to preserve the original sets from being changed by these set methods.)

    2. Write a program that reads text from a text file and displays all the nonduplicate text in 
        ascending order. (Use a TreeSet to hold the text)

    3. Answer the following questions:
        a. Write the code to format number 12345.678 in the United Kingdom locale. 
            Keep two digits after the decimal point.
        b. Write the code to format number 12345.678 in U.S. currency.
        c. Write the code to parse '12,345.678' into a number.
 * 
 * References: 
 * https://www.w3schools.com/java/java_switch.asp
 * https://howtodoinjava.com/java/exception-handling/try-catch-finally/
 * https://www.w3schools.com/java/java_user_input.asp
 * 
 * https://www.w3schools.com/java/java_hashset.asp
 * https://www.demo2s.com/java/java-set-operation-union-intersection-difference.html
 * https://www.w3schools.com/java/java_files_read.asp
 * 
 * 
 * https://www.geeksforgeeks.org/numberformat-getnumberinstance-method-in-java-with-examples/
 * https://www.geeksforgeeks.org/numberformat-getcurrencyinstance-method-in-java-with-examples/
 * https://stackoverflow.com/questions/1006688/how-do-i-show-the-pound-sterling-%C2%A3-sign-in-java-swing
 * https://www.herongyang.com/JDK/Encoding-Conversion-Unicode-Signs-in-Different-Encodings.html
 */

public class HomeworkAssignment4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
                "Please select an option: 1) Create linked hash sets; 2) Read text from a file; 3) Format number 4) Exit");
        // Maybe a try-catch block here to handle invalid input
        switch (scanner.nextInt()) {
            case 1:
                createHashSet();
                break;
            case 2:
                readFromTextFile();
                break;
            case 3:
                formatNumber();
                break;
            default:
                break;
        }
        scanner.close();
    }
    // Create two linked hash sets and find their union, difference, and intersection
    public static void createHashSet() {
        LinkedHashSet<String> hashNames1 = new LinkedHashSet<>();// Create a linked hash set
        LinkedHashSet<String> hashNames2 = new LinkedHashSet<>();
        // Add elements to the hash set
        hashNames1.add("George");
        hashNames1.add("Jim");
        hashNames1.add("John");
        hashNames1.add("Blake");
        hashNames1.add("Kevin");
        hashNames1.add("Michael");

        hashNames2.add("George");
        hashNames2.add("Katie");
        hashNames2.add("Kevin");
        hashNames2.add("Michelle");
        hashNames2.add("Ryan");

        // Union
        LinkedHashSet<String> unionSet = new LinkedHashSet<>(hashNames1);// Clone the first hash set
        unionSet.addAll(hashNames2);//
        System.out.println("Union: " + unionSet);

        // Intersection
        LinkedHashSet<String> intersectionSet = new LinkedHashSet<>(hashNames1);
        intersectionSet.retainAll(hashNames2);
        System.out.println("Intersection: " + intersectionSet);

        // Difference
        LinkedHashSet<String> differenceSet = new LinkedHashSet<>(hashNames1);
        differenceSet.removeAll(hashNames2);
        System.out.println("Difference: " + differenceSet);
    }

    // Removed duplicate method 
    public static void readFromTextFile() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Please enter the file path:");
            String filePath = scanner.nextLine();// Read the file path from the user

            File file = new File(filePath);
            if (!file.exists()) {// Check if the file exists
                System.out.println("File does not exist at path: " + filePath);
                return;
            } else if (!file.canRead()) {// Check if the file can be read
                System.out.println("File cannot be read.");
                return;
            }

            TreeSet<String> uniqueWords = new TreeSet<>();
            try {// Read text from the file and add them to the TreeSet
                Scanner fileScanner = new Scanner(new File(filePath));
                while (fileScanner.hasNext()) {// Add unique words to the TreeSet
                    uniqueWords.add(fileScanner.next());
                }
                fileScanner.close();// Close the file
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                e.printStackTrace();
            }

            System.out.println("Unique words in the file in ascending order: " + uniqueWords);
        } finally {
            scanner.close();
        }
    }

    public static void formatNumber() {
        // Format number 12345.678 in the United Kingdom locale
        NumberFormat ukPoundFormat = NumberFormat.getNumberInstance(Locale.UK);
        ukPoundFormat.setMinimumFractionDigits(2);
        ukPoundFormat.setMaximumFractionDigits(2);
        String poundSign = "\u00A3";
        System.out.println("UK format: " + poundSign + ukPoundFormat.format(12345.678));
        // Locale locale = Locale.UK;
        // Currency curr = Currency.getInstance(locale);
        // System.out.println("UK format: " + curr.getSymbol() + ukPoundFormat.format(12345.678));

        // Format number 12345.678 in U.S. currency
        NumberFormat usDollarFormat = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("US currency format: " + usDollarFormat.format(12345.678));

        // Parse '12,345.678' into a number
        try {
            NumberFormat parsedNumberFormat = NumberFormat.getInstance();
            Number parsedNumber = parsedNumberFormat.parse("12,345.678"); //
            System.out.println("Parsed number: " + parsedNumber);
        } catch (ParseException e) {
            System.out.println("Error parsing number.");
            e.printStackTrace();
        }
    }
}
