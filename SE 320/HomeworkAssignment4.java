import java.util.Scanner;
import java.util.HashSet;
import java.util.Random;

/*
 * SE 320 - Software Construction 
 * Author: Jonathan Legro
 * Date: October 24, 2024
 * Homework Assignment: Four
 * Description: 
    1. Create two linked hash sets {"George", "Jim", "John", "Blake", "Kevin", "Michael"} 
    and {"George", "Katie", "Kevin", "Michelle", "Ryan"} and find their union, difference, and intersection. 
    (You can clone the sets to preserve the original sets from being changed by these set methods.)

    2. Write a program that reads words from a text file and displays all the nonduplicate words in ascending order. 
    (Use a TreeSet to hold the words)

    3. Answer the following questions:
        a. Write the code to format number 12345.678 in the United Kingdom locale. Keep two digits after the decimal point.
        b. Write the code to format number 12345.678 in U.S. currency.
        c. Write the code to parse '12,345.678' into a number.lay the message "Out of Bounds".
 * 
 * References: 
 * https://www.w3schools.com/java/java_switch.asp
 * https://howtodoinjava.com/java/exception-handling/try-catch-finally/
 * https://www.w3schools.com/java/java_user_input.asp
 * 
 * https://www.w3schools.com/java/java_hashset.asp
 * https://www.w3schools.com/java/java_files_read.asp
 */
public class HomeworkAssignment4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select an option: 1) Create two linked hash sets; 2) Reads words from a text file; 3) Format number 4) Exit");
        //Maybe a try-catch block here to handle invalid input
        switch (scanner.nextInt()) {
            case 1:
                createHashSet();
                break;
            case 2:
                readFromTextFile();
                break;
            case 3:
                readFromTextFile();
                break;
            default:
                break;
        }
        scanner.close();
    }

    public static void createHashSet() {
        HashSet<String> cars = new HashSet<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW");
        cars.add("Mazda");
        System.out.println(cars);
      }

    

    public static void readFromTextFile() {
       

    }

    public static void formatNumber(){


    }
}