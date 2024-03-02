package user

import scala.io.StdIn
import scala.collection.mutable

case class User(username: String, password: String)
object User:
    def choosePassword: String = 
        println("Please enter a password of 8 or more characters: ")
        val password = StdIn.readLine()
        password

    def chooseUserName: String = 
        println("Please enter a username: ")
        val username = StdIn.readLine()
        username
