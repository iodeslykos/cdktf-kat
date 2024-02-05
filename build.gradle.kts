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
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.9.22")
    implementation("com.hashicorp:cdktf:0.21.0-pre.41")
    implementation("com.hashicorp:cdktf-provider-docker:11.0.0")
    implementation("software.constructs:constructs:10.3.0")
    implementation("org.junit.jupiter:junit-jupiter:5.10.2")
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
