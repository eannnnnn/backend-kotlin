package dev.waca.socket

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(scanBasePackages = ["dev.waca.services", "dev.waca.socket"])
@EntityScan(basePackages = ["dev.waca.services"])
@EnableJpaRepositories(basePackages = ["dev.waca.services"])
open class SocketApp

const val profileKey = "spring.profiles.active";

fun main(args: Array<String>) {
    val profile = System.getProperty(profileKey)
    if (profile.isNullOrEmpty()) {
        // Profile local
        System.setProperty("spring.profiles.active", "local")

    }
    runApplication<SocketApp>(*args)
}