package dev.waca.services.common.ssh

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Profile
import javax.sql.DataSource

@Configuration
@Profile("local")
open class SSHConfig(private val sshTunnel: SSHTunnel) {

    @Primary
    @Bean("dataSource")
    open fun dataSource(properties:DataSourceProperties ): DataSource {
        val forwardPort = sshTunnel.connection()
        val url = properties.url.replace("5432", forwardPort.toString())
        println(url)

        return DataSourceBuilder.create()
            .url(url)
            .username(properties.username)
            .password(properties.password)
            .build()
    }
}
