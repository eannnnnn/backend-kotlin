package dev.waca.services.common.ssh

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.stereotype.Component

@Component
@EnableConfigurationProperties(SSHConfig::class)
open class SSHTunnel(sshConfig: SSHConfig) {
    init {
        println(sshConfig.url)
    }
}