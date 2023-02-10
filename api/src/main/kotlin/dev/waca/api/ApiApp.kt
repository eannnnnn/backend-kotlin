package dev.waca.api

import dev.waca.services.user.UserDTO
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class ApiApp

fun main(args: Array<String>) {
    val a = UserDTO()

    println(a.toString())
    runApplication<ApiApp>(*args)
}