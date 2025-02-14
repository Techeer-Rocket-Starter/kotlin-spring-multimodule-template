plugins {
    kotlin("plugin.spring")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.25")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.18.2")

    implementation(project(":domain-layer:example-context"))
}

tasks {
    bootJar {
        enabled = false
    }
}
