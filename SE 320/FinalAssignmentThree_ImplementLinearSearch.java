/*
 * SE 320 - Software Construction 
 * 
 * Author: 
 * Jonathan Legro
 * 
 * Date: 
 * December 11, 2024
 * 
 * Homework:  
 * Final Assignment Three
 * 
 * Description: 
 * Implements a generic linear search algorithm that returns the index of a key in an array, or -1 if not found.
 * 
 * References:
 * https://stackoverflow.com/questions/43648174/java-e-extends-comparable-e
 * src/Chapter_19/Exercise_04.java
 */


public class FinalAssignmentThree_ImplementLinearSearch {
    // Generic linear search method
    public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
        for (int i = 0; i < list.length; i++) {
            // Compare the key with the current element in the list
            if (list[i].compareTo(key) == 0) {
                return i; // Return the index if the key is found
            }
        }
        return -1; // Return -1 if the key is not found
    }

    public static void main(String[] args) {
        Integer[] list = {3, 4, 5, 1, -3, -5, -1};
        System.out.println(linearSearch(list, 2)); // Output: -1
        System.out.println(linearSearch(list, 5)); // Output: 2
        System.out.println(linearSearch(list, -5)); // Output: 5
        System.out.println(linearSearch(list, 3)); // Output: 0
    }
}