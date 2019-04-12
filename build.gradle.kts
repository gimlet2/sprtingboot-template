import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	id("io.spring.dependency-management") version "1.0.7.RELEASE"
	id("org.jetbrains.kotlin.jvm") version "1.3.30"
	id("org.jetbrains.kotlin.plugin.spring") version "1.3.30"
	id("org.springframework.boot") version "2.1.4.RELEASE"
	id("com.gorylenko.gradle-git-properties") version "2.0.0"
}


group = "com.restmonkeys"
version = "0.0.1-SNAPSHOT"
val bootJar: BootJar by tasks
bootJar.apply {
	archiveName = "app.jar"
}

java {
	sourceCompatibility = JavaVersion.VERSION_1_8
	targetCompatibility = JavaVersion.VERSION_1_8
}

springBoot {
	buildInfo()
}


repositories {
	mavenCentral()
}

dependencies {
	implementation("ch.qos.logback:logback-classic:1.2.3")
	implementation("ch.qos.logback:logback-core:1.2.3")
	implementation("net.logstash.logback:logstash-logback-encoder:5.3")
	implementation("io.micrometer:micrometer-registry-prometheus:1.1.4")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		languageVersion = "1.3"
		jvmTarget = "1.8"
	}
}