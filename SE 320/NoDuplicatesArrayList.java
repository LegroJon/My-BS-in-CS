/*
 * SE 320 - Software Construction 
 * Author: Jonathan Legro
 * Date: October 14, 2024
 * 
 * Homework: HomeworkAssignment2 
 * Write the following method that returns a new ArrayList.
 * Description: 
 * Method must remove the duplicates when inserted into the list.
 * References:
 * https://www.w3schools.com/java/java_hashset.asp
 * https://www.geeksforgeeks.org/hashset-in-java/
  */
import java.util.ArrayList;
import java.util.HashSet;

public class NoDuplicatesArrayList {
    
public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(14);
        list.add(24);
        list.add(14);
        list.add(42);
        list.add(25);

    ArrayList<Integer> newList = removeDuplicates(list);
    System.out.println(newList);
}

public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
    ArrayList<E> newList = new ArrayList<E>();
    HashSet<E> set = new HashSet<E>();

    for (E element : list){
        if (set.add(element)){
            newList.add(element);
        }
    }
    return newList;
}
}