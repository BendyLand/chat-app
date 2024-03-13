package client

import java.net.{Socket}
import java.io.{BufferedReader, InputStreamReader, PrintWriter}

object Client {
  def main(args: Array[String]): Unit = {
    val serverAddress = "127.0.0.1" // The server's IP address
    val serverPort = 9999 // The port number the server is listening on
    val socket = new Socket(serverAddress, serverPort)
    println("Connected to the server")

    // Create input and output streams to read from and write to the server
    val input = new BufferedReader(new InputStreamReader(socket.getInputStream))
    val output = new PrintWriter(socket.getOutputStream, true)

    // Send a message to the server
    output.println("Hello from the client!")

    // Read the server's response
    val serverResponse = input.readLine()
    println(s"Server says: $serverResponse")

    // Clean up
    socket.close()
  }
}
