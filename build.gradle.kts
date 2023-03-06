plugins {
    kotlin("jvm") version "1.8.0"
}

group = "com.github.mrreallyyo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

    maven {
        url = uri((project.findProperty("github.uri") as String) + "leitemfilter-api")
        credentials {
            username = project.findProperty("github.user") as String
            password = project.findProperty("github.token") as String
        }
    }

}

dependencies {

    implementation("org.jetbrains.kotlinx:kotlinx-cli:0.3.5")
    implementation("org.slf4j:slf4j-simple:2.0.6")

    implementation("com.github.mrreallyyo:leitemfilter-api:1.1")


    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}