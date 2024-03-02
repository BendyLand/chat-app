package server

import message.Message
import user.User
import usermanager.*

class Server:
    def sendMessage(message: Message, to: String) = 
        var inbox = UserManager.users(to)("received")
        inbox += message.body

