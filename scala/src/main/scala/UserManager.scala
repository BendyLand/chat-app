package usermanager

import scala.collection.mutable.{HashMap, ListBuffer}
import user.*

object UserManager:
    // `users` is a HashMap to track users along with with their mailbox, 
    // which itself is a HashMap for sent and received messages. 
    var users = HashMap.empty[User, HashMap[String, ListBuffer[String]]]

    def createUser: User = 
        var username = User.chooseUserName
        while !validateUsername(username) do
            username = User.chooseUserName
        var password = User.choosePassword
        while !validatePassword(password) do
            password = User.choosePassword
        val newUser = User(username, password)
        val mailboxes = HashMap(
            "sent" -> ListBuffer.empty[String],
            "received" -> ListBuffer.empty[String]
        )
        users += (newUser -> mailboxes)
        newUser

    def displayUsers = 
        users.keys.foreach { user => println(user._1) }

    def validateUsername(username: String) = 
        val foundUsers: List[String] = users.keys.toList.map(_.username)
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