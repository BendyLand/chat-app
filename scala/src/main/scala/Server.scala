package server

// import message.Message
// import usermanager.*

// class Server:
//     def sendMessage(message: Message, to: String) = 
//         var inbox = UserManager.users(to)("received")
//         var outbox = UserManager.users(message.from)("sent")
//         outbox += message.body
//         inbox += message.body


// to use: run this file with scala Server.scala, then run scala Client.scala
import java.net.{ServerSocket, Socket}
import java.io.{BufferedReader, InputStreamReader, PrintWriter}

object Server: 
    def main(args: Array[String]): Unit = 
        val serverPort = 9999 // This is the port number the server will listen on
        val serverSocket = new ServerSocket(serverPort)
        println(s"Server is listening on port $serverPort")

        try 
            val clientSocket: Socket = serverSocket.accept() // Accept a connection from a client
            println("Client connected")

            // Create input and output streams to read from and write to the client
            val input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream))
            val output = new PrintWriter(clientSocket.getOutputStream, true)

            val clientMessage = input.readLine() // Read a message sent by the client
            println(s"Client says: $clientMessage")

            // Send a response back to the client
            output.println("Hello from the server!")

            // Clean up
            clientSocket.close()
        finally 
            serverSocket.close()
        
    

