/*
 * SE 320 - Software Construction 
 * Author: Jonathan Legro
 * Date: October 14, 2024
 * 
 * Homework: HomeworkAssignment2 #3
 * Write a Java program that prompts the user to enter a number between 0
and 10 and displays the entered number.

 * Description:  Use an "assert statement" to determine
whether the user entered a number within the valid range. If the user entered a number
that is out of range, the program must report an error with assertion error message
"The entered number is out of range".
 * 
 * References:
 * https://www.oracle.com/java/technologies/downloads/#jdk23-windows
 * https://www.geeksforgeeks.org/assertions-in-java/
 * https://www.programiz.com/java-programming/assertions
 */

 import java.util.Scanner;

 public class AssertStatement {
 
     public static void enterNumberInRange(int number) {  // Pass the number as a parameter
                 
         //Check if the entered number is within range
         assert (number >= 0 && number <= 10) : "The entered number is out of range";
 
         // If the assertion passes, print the number
         System.out.println("You entered the number: " + number);
     }
 
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
 
         System.out.print("Please enter a number between 0 and 10: ");
         int number = scanner.nextInt();
         
         enterNumberInRange(number);  // Pass the number to the method
 
         scanner.close();
     }
 }
 
