package main

import user.*
import usermanager.*
import message.*
import server.*

class Main:
    @main def run(): Unit =
        server.init()
        // TODO: update User, UserManager, and Message for the new Server and Client structure
        