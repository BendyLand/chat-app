import user.*
import usermanager.*
import message.*
import server.*

@main def hello(): Unit =
    val user1 = User.create
    val user2 = User.create
    val userManager = UserManager
    userManager.addNewUser(user1)
    userManager.addNewUser(user2)

    userManager.displayUsers

    val server = Server()
    val testMessage = Message(user1.username, "This is a test message for the first time")

    server.sendMessage(testMessage, user2.username)
    userManager.displayInbox(user2)
