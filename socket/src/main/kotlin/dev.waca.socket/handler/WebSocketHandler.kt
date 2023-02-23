package dev.waca.socket.handler

import org.springframework.stereotype.Component
import org.springframework.web.socket.BinaryMessage
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.WebSocketMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.BinaryWebSocketHandler

val sessions = mutableListOf<WebSocketSession>()

@Component
class WebSocketHandler : BinaryWebSocketHandler() {

    // web socket connected
    override fun afterConnectionEstablished(session: WebSocketSession) {
        super.afterConnectionEstablished(session)
        println("Connected to socket")
        println(session.id)
        session.sendMessage(BinaryMessage("Hello".toByteArray()))
        sessions.add(session)
    }

    override fun handleMessage(session: WebSocketSession, message: WebSocketMessage<*>) {
        println("Message received")
        println(session.id)
        println(message.payload)

        session.sendMessage(BinaryMessage((message.payload as String).toByteArray()))
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        super.afterConnectionClosed(session, status)
        println("Closed socket")
        println(session.id)
        sessions.remove(session)
    }
}