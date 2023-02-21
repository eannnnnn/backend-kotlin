package dev.waca.api.controller.user

import dev.waca.services.user.UserRepository
import dev.waca.services.user.entities.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/user")
@RestController("User Controller")
class UserController {
    @Autowired lateinit var userRepository: UserRepository

    @GetMapping
    fun getUser(): MutableList<User> {
        return userRepository.findAll()
    }
}