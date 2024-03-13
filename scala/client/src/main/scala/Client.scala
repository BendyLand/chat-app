package client

import java.net.{Socket}
import java.io.{BufferedReader, InputStreamReader, PrintWriter}

object Client: 
    @main def init(): Unit = 
        // Initialize the connection with the created variables, then print success message
        val serverAddress = "127.0.0.1" 
        val serverPort = 9998 
        val socket = Socket(serverAddress, serverPort)
        println("Connected to the server")
        
        // Create input and output streams to read from and write to the server
        val input = BufferedReader(InputStreamReader(socket.getInputStream))
        val output = PrintWriter(socket.getOutputStream, true)
        
        // Send a message to the server, read input from server, then print it to the console
        output.println("Hello from the client!")
        val serverResponse = input.readLine()
        println(s"Server says: $serverResponse")

        // Clean up
        socket.close()
