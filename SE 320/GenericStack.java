/*
 * SE 320 - Software Construction 
 * Author: Jonathan Legro
 * Date: October 14, 2024
 * 
 * Homework: Revise the GenericStack class to implement it using an array rather than an ArrayList:
 * 
 * Description: 
 * • You must have a constructor to construct a stack with the default initial capacity.
 * • You must have another constructor to construct a stack with a specified initial capacity.
 * • You should check the array size before adding a new element to the stack. If the array is
 *      full, create a new array that doubles the current array size and copy the elements from
 *      the current array to the new array.
 * 
 * References:
 * https://www.geeksforgeeks.org/how-to-implement-stack-in-java-using-array-and-generics/
 * https://www.geeksforgeeks.org/implement-stack-using-array/
 * https://www.geeksforgeeks.org/java-program-to-implement-stack-data-structure/ 
 */

public class GenericStack<E> {
    private E[] arrayStack; // Array to store stack elements
    private int size;  // Number of elements in the stack
    private int capacity; // Maximum size of the stack

    // Constructor for default capacity
    public GenericStack() {
        this.capacity = 16; 
        this.arrayStack = (E[]) new Object[capacity]; // Create a stack with the default capacity
        this.size = 0;
    }
    // Constructor for specific capacity
    public GenericStack(int specificCapacity) {
        this.capacity = specificCapacity;
        this.arrayStack = (E[]) new Object[capacity]; // Create a stack with the specified capacity
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    //Push method to add elements to the stack
    public void push(E element){
        if (size >= capacity){
            capacity *= 2;
            E[] new_Stack = (E[]) new Object[capacity];// Create a new stack with double the capacity
            for (int i = 0; i < size; i++){
                new_Stack[i] = arrayStack[i];// Copy the elements from the old stack to the new array
            }
            arrayStack = new_Stack; // Replace the old stack with the new stack
        }
        arrayStack[size++] = element; // Add the element to the stack
    }

    public E pop(){
        if (size == 0){
            throw new java.util.EmptyStackException();
        }   
        E element = arrayStack[size - 1]; // Get the element at the top of the stack
        arrayStack[size - 1] = null; // Remove the element from the stack
        size--; // Decrement the size of the stack
        return element;
    }

    public E peek() {
        if(size == 0){
            throw new java.util.EmptyStackException();
        }
        return arrayStack[size - 1]; // Get the element at the top of the stack
        }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        return "Stack: " + java.util.Arrays.toString(arrayStack);
    }

    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStack<Integer>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        System.out.println("Size: " + stack.getSize());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.getSize());
        System.out.println("Empty: " + stack.isEmpty());
        System.out.println(stack);
    }

}
