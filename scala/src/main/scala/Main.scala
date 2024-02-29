import user.*

@main def hello(): Unit =
    val user = User.create()
    println(user.username)
    println(user.password)


