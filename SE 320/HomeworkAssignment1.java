import java.util.Scanner;
import java.util.Random;

/*
 * SE 320 - Software Construction 
 * Author: Jonathan Legro
 * Date: September 21, 2024
 * Homework Assignment: One
 * Description: 
 * A Java program that prompts the user to enter two integers and displays their sum. 
 * Uses an exception handling to prompt the user for reading the number again if the input is incorrect.
 * 
 * Creates an array with 100 randomly chosen integers.
 * Prompts the user to enter the index of the array, then displays the corresponding element value. 
 * If the specified index is out of bounds, catch the exception and display the message "Out of Bounds".
 * 
 * References: 
 * https://www.w3schools.com/java/java_switch.asp
 * https://howtodoinjava.com/java/exception-handling/try-catch-finally/
 * https://www.w3schools.com/java/java_user_input.asp
 */
public class HomeworkAssignment1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select an option: 1) Sum two integers; 2) Create a random array; 3) Exit");
        //Maybe a try-catch block here to handle invalid input
        switch (scanner.nextInt()) {
            case 1:
                sumOfTwoIntegers();
                break;
            case 2:
                createRandomArray();
                break;
            default:
                break;
        }
        scanner.close();
    }

    public static void sumOfTwoIntegers() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        int firstInt = 0, secondInt = 0;

        while (!validInput) {
            try {
                //Maybe seperate the inpur into two try-catch blocks
                System.out.print("Enter the first integer: ");
                firstInt = Integer.parseInt(scanner.nextLine());
                
                System.out.print("Enter the second integer: ");
                secondInt = Integer.parseInt(scanner.nextLine());

                validInput = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter valid integers.");
            }
        }
        scanner.close();

        int sum = firstInt + secondInt;
        System.out.println("The sum of the two integers is: " + sum);
    }

    public static void createRandomArray() {
        Random random = new Random();
        int[] myRandomArray = new int[100];

        for (int i = 0; i < myRandomArray.length; i++) {
            myRandomArray[i] = random.nextInt(100);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the index of the array: ");

        try {
            int index = scanner.nextInt();
            System.out.println("Element at index " + index + ": " + myRandomArray[index]);
        } catch (Exception e) {
            System.out.println("Out of Bounds");
        } finally {
            scanner.close();
        }
    }
}