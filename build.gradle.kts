plugins {
    id("java")
    id("io.qameta.allure") version "3.0.1"
}

java { toolchain { languageVersion.set(JavaLanguageVersion.of(17)) } }

allure {
    val allureVersion = "2.32.0"

    report {
        version.set(allureVersion)
    }
    adapter {
        aspectjWeaver.set(true)
        frameworks {
            junit5 {
                adapterVersion.set(allureVersion)
            }
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    val allureSelenideVersion = "2.32.0"
    val assertjCoreVersion = "3.27.7"
    val datafakerVersion = "2.5.3"
    val jacksonVersion = "3.0.4"
    val junitVersion = "6.0.2"
    val logbackVersion = "1.5.27"
    val ownerVersion = "1.0.12"
    val selenideVersion = "7.14.0"
    val slf4jVersion = "2.0.17"


    testImplementation("io.qameta.allure:allure-selenide:${allureSelenideVersion}")
    testImplementation("org.assertj:assertj-core:${assertjCoreVersion}")
    testImplementation("net.datafaker:datafaker:${datafakerVersion}")
    testImplementation("tools.jackson.core:jackson-databind:${jacksonVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter:${junitVersion}")
    testImplementation("ch.qos.logback:logback-classic:${logbackVersion}")
    testImplementation("org.aeonbits.owner:owner:${ownerVersion}")
    testImplementation("com.codeborne:selenide:${selenideVersion}")
    testImplementation("org.slf4j:slf4j-api:${slf4jVersion}")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<Test> {
    systemProperty("file.encoding", "UTF-8")

    val properties = mapOf(
        "config.file" to System.getProperty("config.file"),
        "remoteUsername" to System.getProperty("remoteUsername"),
        "remotePassword" to System.getProperty("remotePassword")
    )

    properties.forEach { (key, value) ->
        if (value != null) {
            systemProperty(key, value)
        }
    }

    useJUnitPlatform()

    testLogging {
        events("started", "skipped", "failed", "standard_error", "standard_out")
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.SHORT
    }
}