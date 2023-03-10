import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

val javaVersion: JavaVersion = JavaVersion.toVersion(property("build.version.java")!!)
val javaVersionName: String = javaVersion.toString()
val kotlinVersion: String = property("build.version.kotlin")!!.toString()
val kotlinCompatibility: String = kotlinVersion.substring(0..2)

java {
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = javaVersionName
        apiVersion = kotlinCompatibility
        languageVersion = kotlinCompatibility
    }
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    implementation("com.android.tools.build:gradle:8.0.0-beta04")

    implementation("com.google.dagger:hilt-android-gradle-plugin:2.45")
    implementation("com.google.firebase:firebase-crashlytics-gradle:2.9.4")
    implementation("com.google.firebase:perf-plugin:1.4.2")
    implementation("com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:2.0.1")
}