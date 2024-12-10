/*
 * SE 320 - Software Construction 
 * 
 * Author: 
 * Jonathan Legro
 * 
 * Date: 
 * December 10, 2024
 * 
 * Homework: 
 * Final Assignment Server
 * 
 * Description: 
 * Revise the server program in Question-1 using threads to allow multiple clients.
 * 
 * Write a server program and a client program. The client sends the weight and height for a person to the server. 
 * The server computes BMI (Body Mass Index) and sends back to the client a string that reports the BMI.
 * You can use the following formula for computing BMI: 
 * bmi = weightInKilograms / (heightInMeters * heightInMeters)
 * 
 * References:
 * https://www.geeksforgeeks.org/how-to-create-a-simple-tcp-client-server-connection-in-java/
 * https://www.geeksforgeeks.org/socket-programming-in-java/
 * https://www.geeksforgeeks.org/establishing-the-two-way-communication-between-server-and-client-in-java/
 * https://www.geeksforgeeks.org/multithreaded-servers-in-java/
 * https://www.geeksforgeeks.org/multi-threaded-chat-application-set-1/
 */

 import java.net.*;
 import java.io.*;
 import java.util.Vector;
 
 public class FinalAssignmentTwo_BMI_Server_Threads {
     static Vector<ClientHandler> ar = new Vector<>();
     static int i = 0; // Count for clients
 
     // ClientHandler to handle each client connection
     class ClientHandler extends Thread {
         private Socket s;
         private BufferedReader in;
         private DataOutputStream out;
 
         public ClientHandler(Socket s) {
             this.s = s;
         }
         
         @Override
         public void run() {
             try {
                 // Input from the client
                 in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                 // Output to the client
                 out = new DataOutputStream(s.getOutputStream());
 
                 // Read weight and height from client
                 String weightStr = in.readLine();
                 String heightStr = in.readLine();
 
                 double weight = Double.parseDouble(weightStr);
                 double height = Double.parseDouble(heightStr);
 
                 // Compute BMI
                 double bmi = weight / (height * height);
 
                 // Send BMI result to client
                 out.writeBytes("Your BMI is: " + bmi + "\n");
 
                 // Close connection
                 in.close();
                 out.close();
                 s.close();
                 System.out.println("Client connection closed.");
             } catch (IOException e) {
                 System.out.println("ClientHandler Error: " + e.getMessage());
             }
         }
     }
 
     public FinalAssignmentTwo_BMI_Server_Threads(int port) {
         try (ServerSocket server = new ServerSocket(port)) {
             System.out.println("Server started on port " + port);
             System.out.println("Waiting for clients ...");
 
             // Continuously accept clients
             while (true) {
                 Socket socket = server.accept();
                 System.out.println("Client accepted");
                 
                 // Create a new handler object for each client
                 ClientHandler mtch = new ClientHandler(socket);
 
                 // Add this client handler to the active clients vector
                 ar.add(mtch);
 
                 // Start the handler thread
                 mtch.start();
             }
 
         } catch (IOException i) {
             System.out.println("Server Error: " + i.getMessage());
         }
     }
 
     public static void main(String[] args) {
         // Run the server on port 5000
         new FinalAssignmentTwo_BMI_Server_Threads(5000);
     }
 }
 