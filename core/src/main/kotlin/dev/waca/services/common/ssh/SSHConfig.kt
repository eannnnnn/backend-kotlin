package dev.waca.services.common.ssh

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "ssh")
data class SSHConfig(
    var url: String = "",
    var port: Int = 0,
    var username: String = "",
    var password: String = "",
)
