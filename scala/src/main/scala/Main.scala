import user.*
import usermanager.*

@main def hello(): Unit =
    val user = UserManager.createUser
    val user2 = UserManager.createUser

    println(user.username)
    println(user.password)
    println(user2.username)
    println(user2.password)

    UserManager.displayUsers

