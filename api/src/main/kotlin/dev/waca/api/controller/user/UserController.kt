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
    private val sshConfig: SSHConfig
) {


    @GetMapping
    fun getUser(): String {
        println(env.getProperty("ssh.url"))
        println(sshConfig.url)
        return "abc"
    }
}