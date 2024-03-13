package server

import java.net.{ServerSocket, Socket}
import java.io.{BufferedReader, InputStreamReader, PrintWriter}

object Server: 
    @main def init(): Unit = 
        // Assign a server port, create a socket from that port, then print an init message
        val serverPort = 9998 
        val serverSocket = ServerSocket(serverPort) 
        println(s"Server is listening on port $serverPort")
        try 
            // Wait for incoming connection
            val clientSocket: Socket = serverSocket.accept() 

            // Print success message, then create streams to read from and write to the client
            println("Client connected")
            val input = BufferedReader(InputStreamReader(clientSocket.getInputStream))
            val output = PrintWriter(clientSocket.getOutputStream, true)

            // Retrieve the message sent by the client, print it to the console, and send a message back
            val clientMessage = input.readLine() 
            println(s"Client says: $clientMessage")
            output.println("Hello from the server!")

            // Clean up
            clientSocket.close()
        finally 
            // remember to close the server socket regardless of if the client connection fails
            serverSocket.close()
        