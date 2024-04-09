import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	id("io.spring.dependency-management") version "1.1.4"
	id("org.graalvm.buildtools.native") version "0.10.1"
	id("org.springframework.boot") version "3.2.4"
	id("com.gorylenko.gradle-git-properties") version "2.4.1"
	kotlin("jvm") version "1.9.22"
	kotlin("plugin.spring") version "1.9.22"
}


group = "com.restmonkeys"
version = "0.0.1-SNAPSHOT"

tasks.named<BootJar>("bootJar") {
	archiveFileName.set("app.jar")
}

java {
	sourceCompatibility = JavaVersion.VERSION_21
	targetCompatibility = JavaVersion.VERSION_21
}

springBoot {
	buildInfo()
}


repositories {
	mavenCentral()
}

dependencies {
	implementation("ch.qos.logback:logback-classic:1.5.3")
	implementation("ch.qos.logback:logback-core:1.5.3")
	implementation("net.logstash.logback:logstash-logback-encoder:7.4")
	implementation("io.micrometer:micrometer-registry-prometheus:1.12.5")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation(platform("org.junit:junit-bom:5.10.2"))
	testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
	useJUnitPlatform()
	testLogging {
		events("passed", "skipped", "failed")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		languageVersion = "1.8"
		jvmTarget = "21"
	}
}
