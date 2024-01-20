import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.22"
    application
}

val version: String by project
val group: String by project

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.7.10")
    implementation("com.hashicorp:cdktf:0.12.2")
    implementation("com.hashicorp:cdktf-provider-docker:2.0.54")
    implementation("software.constructs:constructs:10.1.98")
    implementation("org.junit.jupiter:junit-jupiter:5.9.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

application {
    mainClass.set("com.iodeslykos.cdktf.AppTemplate")
}
