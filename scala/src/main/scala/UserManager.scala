package usermanager

import user.*

object UserManager:
    def createUser: User = 
        var username = User.getUserName
        while !User.validateUsername(username) do
            username = User.getUserName

        var password = User.getPassword
        while !User.validatePassword(password) do
            password = User.getPassword

        User.existingUsers += username 
        User(username, password)

    def displayUsers = 
        println(User.existingUsers)
