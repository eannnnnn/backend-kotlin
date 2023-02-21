package dev.waca.services.common.ssh

import com.jcraft.jsch.JSch
import com.jcraft.jsch.Session
import jakarta.annotation.PreDestroy
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Profile
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component
import java.sql.DriverManager


@Component
@Profile("local")
open class SSHTunnel(
    private val env: Environment
) {
    private val logger = LoggerFactory.getLogger(SSHTunnel::class.java)
    private var session: Session? = null;
    fun connection(): Int {
        val url = env.getProperty("ssh.url")!!
        val port = env.getProperty("ssh.port", Int::class.java)!!
        val username = env.getProperty("ssh.username")!!
        val password = env.getProperty("ssh.password")!!
        val targetHost = env.getProperty("ssh.targetHost")!!
        val targetPort = env.getProperty("ssh.targetPort", Int::class.java)!!

        val forwardPort: Int;
        try {
            logger.info("SSH TUNNEL =============> From {}", url);
            val jsch = JSch();

            session = jsch.getSession(username, url, port);
            session!!.setPassword(password)
            session!!.setConfig("StrictHostKeyChecking", "no")
            session!!.connect()
            forwardPort = (session as Session).setPortForwardingL(0, targetHost, targetPort)
            logger.info("SSH TUNNEL =============> To {} PORT", forwardPort);
        } catch (e: Exception) {
            logger.error("Error creating SSH tunnel", e)
            throw e
        }
        return forwardPort;
    }

    @PreDestroy
    fun close() {
        if (session?.isConnected == true) {
            session!!.disconnect()
        }
    }
}