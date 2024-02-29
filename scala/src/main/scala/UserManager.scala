package usermanager

import user.*

object UserManager:
    def displayUsers = 
        println(User.existingUsers)
