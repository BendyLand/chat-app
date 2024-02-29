package user

import scala.io.StdIn
import scala.collection.mutable

case class User(username: String, password: String)
object User:
    var existingUsers = mutable.ListBuffer.empty[String]
    def create: User = 
        var username = getUserName
        while !validateUsername(username) do
            username = getUserName

        var password = getPassword
        while !validatePassword(password) do
            password = getPassword

        existingUsers += username 
        User(username, password)

    def getPassword: String = 
        println("Please enter a password of 8 or more characters: ")
        val password = StdIn.readLine()
        password

    def getUserName: String = 
        println("Please enter a username: ")
        val username = StdIn.readLine()
        username

    def validateUsername(username: String) = 
        if existingUsers.contains(username) then
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