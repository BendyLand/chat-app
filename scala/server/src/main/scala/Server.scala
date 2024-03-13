package server

// to use: run this file with scala Server.scala, then run scala Client.scala (both need a main method)
import java.net.{ServerSocket, Socket}
import java.io.{BufferedReader, InputStreamReader, PrintWriter}
// import message.Message
// import usermanager.*

// TODO: old code. find a way to refactor into new code, or remove
// class Server:
//     def sendMessage(message: Message, to: String) = 
//         var inbox = UserManager.users(to)("received")
//         var outbox = UserManager.users(message.from)("sent")
//         outbox += message.body
//         inbox += message.body

object Server: 
    @main def init(): Unit = 
        val serverPort = 9998 // this is where the server port will listen
        val serverSocket = ServerSocket(serverPort) // create a socket from the server port
        println(s"Server is listening on port $serverPort")
        try 
            // blocks execution while waiting for a client connection
            val clientSocket: Socket = serverSocket.accept() // .accept() listens on the created server socket 

            // once a client connects to the socket, code begins executing here
            println("Client connected")

            // Create input and output streams to read from and write to the client
            val input = BufferedReader(InputStreamReader(clientSocket.getInputStream))
            val output = PrintWriter(clientSocket.getOutputStream, true)
            val clientMessage = input.readLine() // Read a message sent by the client
            println(s"Client says: $clientMessage")

            // Send a response back to the client
            output.println("Hello from the server!")

            // Clean up
            clientSocket.close()
        finally 
            // if client connection fails, remember to close the server socket
            serverSocket.close()
        