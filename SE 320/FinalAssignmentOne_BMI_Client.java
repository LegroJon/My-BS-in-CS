/*
 * SE 320 - Software Construction 
 * 
 * Author: 
 * Jonathan Legro
 * 
 * Date: 
 * December 07, 2024
 * 
 * Homework: 
 * Final Assignment Client
 * 
 * Description: Write a server program and a client program. The client sends the weight and height for a person to the server. 
 * The server computes BMI (Body Mass Index) and sends back to the client a string that reports the BMI.
 * You can use the following formula for computing BMI: 
 * bmi = weightInKilograms / (heightInMeters * heightInMeters)
 * 
 * References:
 * https://www.geeksforgeeks.org/how-to-create-a-simple-tcp-client-server-connection-in-java/
 * https://www.geeksforgeeks.org/socket-programming-in-java/
 * https://www.geeksforgeeks.org/establishing-the-two-way-communication-between-server-and-client-in-java/
 */

 import java.io.*;
 import java.net.*;
 
 public class FinalAssignmentOne_BMI_Client {
     // Initialize socket and input/output streams
     private Socket socket = null;
     private BufferedReader userInput = null;
     private DataOutputStream out = null;
     private BufferedReader serverInput = null;
 
     // Constructor to connect to server
     public FinalAssignmentOne_BMI_Client(String address, int port) {
         try {
             socket = new Socket(address, port);
             System.out.println("Connected to server");
 
             // Input from user (console)
             userInput = new BufferedReader(new InputStreamReader(System.in));
             // Output to server
             out = new DataOutputStream(socket.getOutputStream());
             // Input from server
             serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
 
             // Prompt user for weight and height
             System.out.print("Enter weight in kilograms: ");
             String weight = userInput.readLine();
             System.out.print("Enter height in meters: ");
             String height = userInput.readLine();
 
             // Send weight and height to server
             out.writeBytes(weight + "\n");
             out.writeBytes(height + "\n");
 
             // Read BMI result from server
             String response = serverInput.readLine();
             System.out.println("Server: " + response);
 
             // Close connection
             socket.close();
             out.close();
             userInput.close();
             serverInput.close();
 
         } catch (UnknownHostException u) {
             System.out.println(u);
         } catch (IOException i) {
             System.out.println(i);
         }
     }
 
     public static void main(String args[]) {
         // Connect to server on localhost:5000
         FinalAssignmentOne_BMI_Client client = new FinalAssignmentOne_BMI_Client("127.0.0.1", 5000);
     }
 }