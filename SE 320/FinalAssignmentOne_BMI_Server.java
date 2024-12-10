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

import java.net.*;
import java.io.*;

public class FinalAssignmentOne_BMI_Server {
    // Initialize socket and input/output streams
    private Socket socket = null;
    private ServerSocket server = null;
    private BufferedReader in = null;
    private DataOutputStream out = null;

    // Constructor with port
    public FinalAssignmentOne_BMI_Server(int port) {
        try {
            // Start server and wait for a client
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");

            // Input from the client
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // Output to the client
            out = new DataOutputStream(socket.getOutputStream());

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
            socket.close();
            in.close();
            out.close();
            System.out.println("Connection closed");

        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        // Run the server on port 5000
        FinalAssignmentOne_BMI_Server server = new FinalAssignmentOne_BMI_Server(5000);
    }
}