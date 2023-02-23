package dev.waca.socket.controller

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessageSendingOperations
import org.springframework.stereotype.Controller

@Controller
class WebSocketController ( private val sendingOperations : SimpMessageSendingOperations){

    @MessageMapping("/message")
    fun message(message: String) {
        sendingOperations.convertAndSend("/sub/message", message)
    }

}