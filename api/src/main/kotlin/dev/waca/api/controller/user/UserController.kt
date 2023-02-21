package dev.waca.api.controller.user

import dev.waca.services.common.ssh.SSHConfig
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/user")
@RestController("User Controller")
class UserController(
    private val env: Environment,
) {


    @GetMapping
    fun getUser(): String {
        return "abc"
    }
}