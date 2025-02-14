plugins {
    kotlin("plugin.spring")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework:spring-tx")

    implementation(project(":domain-layer:example-context"))
}

tasks {
    bootJar {
        enabled = false
    }
}
