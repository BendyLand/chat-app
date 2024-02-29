import user.*
import usermanager.*

@main def hello(): Unit =
    val user = User.create
    val user2 = User.create
    println(user.username)
    println(user.password)
    println(user2.username)
    println(user2.password)

    UserManager.displayUsers

