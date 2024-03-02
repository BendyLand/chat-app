package usermanager

import scala.collection.mutable
import user.*

object UserManager:
    var users = mutable.HashMap.empty[User, mutable.ListBuffer[String]]

    def createUser: User = 
        var username = User.chooseUserName
        while !validateUsername(username) do
            username = User.chooseUserName
        var password = User.choosePassword
        while !validatePassword(password) do
            password = User.choosePassword
        val newUser = User(username, password)
        users += (newUser, mutable.ListBuffer.empty[String])
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