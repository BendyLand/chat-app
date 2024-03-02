package usermanager

import scala.collection.mutable.{HashMap, ListBuffer}
import user.*

object UserManager:
    // `users` is a HashMap to track users along with with their mailbox, 
    // which itself is a HashMap for sent and received messages. 
    var users = HashMap.empty[String, HashMap[String, ListBuffer[String]]]

    def displayInbox(user: User): ListBuffer[String] = 
        users(user.username)("received")

    def addNewUser(user: User) = 
        val mailboxes = HashMap(
            "sent" -> ListBuffer.empty[String],
            "received" -> ListBuffer.empty[String]
        )
        users += (user.username, mailboxes)

    def displayUsers = 
        users.keys.foreach(println)

    def validateUsername(username: String) = 
        val foundUsers: List[String] = users.keys.toList
        if foundUsers.contains(username) then
            println("Username already taken. Please choose a different one.")
            false
        else
            true

    def validatePassword(password: String) = 
        if password.length < 8 then
            println("Password too short. Please try again.")
            false
        else
            true