import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.io.FileNotFoundException;
import java.time.temporal.ChronoUnit;

/*
 * SE 320 - Software Construction 
 * Author: Jonathan Legro
 * Date: November 24, 2024
 * Homework Assignment: Five
 * Description: 
    1. Write a program that computes the number of days that have elapsed since you were born.
        Use the Day class we studied in class, not the GregorianCalendar class. You can find all three
        implementations of the Day class (that we've seen in class) on Canvas, under
        Modules>Supplementary Material.
    2. Write a precondition or requires clause for the method removeDuplicates, so all duplicates
        from List lst are removed.
    
 * 
 * References: 
 * https://www.w3schools.com/java/java_switch.asp
 * https://howtodoinjava.com/java/exception-handling/try-catch-finally/
 * https://www.w3schools.com/java/java_user_input.asp
 * 
 * https://stackoverflow.com/questions/47753105/count-the-number-of-days-including-the-two-given-dates
 * https://beginnersbook.com/2017/10/java-8-calculate-days-between-two-dates/
    */

public class HomeworkAssignment5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
                "Please select an option: 1) Compute total number of days from birth; 2) Print precondition; 3) Exit");
        switch (scanner.nextInt()) {
            case 1:
                noOfDaysBetween();
                break;
            default:
                break;
        }
        scanner.close();
    }

    static void noOfDaysBetween() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter your birthdate in the format YYYY-MM-DD");
            try {
                LocalDate birthdate = LocalDate.parse(scanner.nextLine());
                LocalDate currentDate = LocalDate.now();
                long days = ChronoUnit.DAYS.between(birthdate, currentDate);
                System.out.println("Total number of days since birth: " + days);
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter date in the format YYYY-MM-DD");
            }
        } catch (Exception e) {
            System.out.println("An error occurred. Please try again.");
        }
        finally {
            System.out.println("Leaving program...");
        }
    }
}
