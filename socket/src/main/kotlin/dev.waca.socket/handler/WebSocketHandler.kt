package dev.waca.socket.handler

import dev.waca.services.utils.stringGsonMapper
import dev.waca.socket.dtos.ReceiveMessageDTO
import org.springframework.stereotype.Component
import org.springframework.web.socket.BinaryMessage
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.WebSocketMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.BinaryWebSocketHandler

@Component
class WebSocketHandler : BinaryWebSocketHandler() {

    override fun handleMessage(session: WebSocketSession, message: WebSocketMessage<*>) {
        try {
            val receiveMessage = stringGsonMapper(message.payload as String, ReceiveMessageDTO::class.java)
            println(receiveMessage.channel)
        } catch (e: Exception) {
            session.sendMessage(BinaryMessage(e.printStackTrace().toString().toByteArray()))
        }
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        println("Closed socket")
        println(session.id)
//        sessions.remove(session)
    }
}