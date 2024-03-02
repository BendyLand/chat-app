package usermanager

import scala.collection.mutable.{HashMap, ListBuffer}
import user.*

object UserManager:
    var users = HashMap.empty[String, HashMap[String, ListBuffer[String]]]

    def displayInbox(user: User) = 
        println("Here are the messages from your inbox: ")
        users(user.username)("received").foreach(println)

    def addNewUser(user: User) = 
        val mailboxes = HashMap(
            "sent" -> ListBuffer.empty[String],
            "received" -> ListBuffer.empty[String]
        )
        users += user.username -> mailboxes 

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