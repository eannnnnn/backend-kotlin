import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot") version "3.0.2" apply false
    id("io.spring.dependency-management") version "1.1.0" apply false
    kotlin("jvm") version "1.8.0"
    kotlin("plugin.spring") version "1.8.0"
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply {
        plugin("kotlin")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        compileOnly("org.projectlombok:lombok")
        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
        annotationProcessor("org.projectlombok:lombok")

        implementation("com.jcraft:jsch:0.1.55")
        runtimeOnly("org.postgresql:postgresql")

        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("org.springframework.boot:spring-boot-starter-web")

        testImplementation(kotlin("test"))
    }
    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    group = "dev.waca"
    version = "1.0-SNAPSHOT"

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    tasks.test {
        useJUnitPlatform()
    }
}

project(":core") {
    val jar: Jar by tasks
    val bootJar: BootJar by tasks

    bootJar.enabled = false
    jar.enabled = true

    dependencies {
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    }
}

project(":api") {
    dependencies {
        compileOnly(project(":core"))
        implementation("org.springframework.restdocs:spring-restdocs-mockmvc")
        implementation("org.springframework.boot:spring-boot-starter-actuator")
    }
}