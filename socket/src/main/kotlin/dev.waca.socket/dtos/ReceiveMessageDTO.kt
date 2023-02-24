package dev.waca.socket.dtos


data class ReceiveMessageDTO(
    val method: String,
    val channel: String,
    val data: Any
)
