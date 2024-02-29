package user

import scala.io.StdIn

case class User(username: String, password: String)
object User:
    def create(): User = 
        val (username, password) = getUserInfo
        if validatePassword(password) then
            User(username, password)
        else
            println("Password too short. Please try again")
            create()

    def getUserInfo = 
        println("Please enter a username: ")
        val username = StdIn.readLine()
        println("Please enter a password of 8 or more characters: ")
        val password = StdIn.readLine()
        (username, password)

    def validatePassword(password: String) = 
        password match
            case x if x.length < 8 => false
            case _ => true