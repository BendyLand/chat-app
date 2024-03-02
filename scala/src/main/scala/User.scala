package user

import scala.io.StdIn
import scala.collection.mutable
import usermanager.UserManager

case class User(username: String, password: String)
object User:
    def create: User = 
        var username = User.chooseUserName
        while !UserManager.validateUsername(username) do
            username = User.chooseUserName
        var password = User.choosePassword
        while !UserManager.validatePassword(password) do
            password = User.choosePassword
        User(username, password)

    def choosePassword: String = 
        println("Please enter a password of 8 or more characters: ")
        val password = StdIn.readLine()
        password

    def chooseUserName: String = 
        println("Please enter a username: ")
        val username = StdIn.readLine()
        username
