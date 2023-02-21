package dev.waca.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan


@ComponentScan("dev.waca")
@SpringBootApplication
open class ApiApp;

const val profileKey = "spring.profiles.active";
fun main(args: Array<String>) {
    val profile = System.getProperty(profileKey)
    if (profile.isNullOrEmpty()) {
        // Profile local
        System.setProperty("spring.profiles.active", "local")

    }
    runApplication<ApiApp>(*args)
}