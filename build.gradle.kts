plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.5.2"

}

apply(null, "java", null)
apply(null, "groovy", null)
apply(null, "idea", null)
apply(null, "org.jetbrains.intellij", null)

group = "com.dengzii.plugin"
version = "1.2"

repositories {
    mavenCentral()
}


// Configure Gradle IntelliJ Plugin - read more: https://github.com/JetBrains/gradle-intellij-plugin
intellij {
    version.set("2022.1")
    type.set("IC") // Target IDE Platform

    plugins.set(
        listOf(
            "java", "org.jetbrains.kotlin"
        )
    )
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "11"
        targetCompatibility = "11"
    }

    patchPluginXml {
        sinceBuild.set("203")
        untilBuild.set("223.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}
