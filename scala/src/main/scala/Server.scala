package server

import message.Message
import user.User
import usermanager.*

class Server:
    def sendMessage(message: Message, to: String) = 
        var inbox = UserManager.users(to)("received")
        var outbox = UserManager.users(message.from)("sent")
        outbox += message.body
        inbox += message.body

