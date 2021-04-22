plugins {
	kotlin("jvm") version "1.4.30" apply false
}

buildscript {
	dependencies {
		classpath("com.squareup.anvil:gradle-plugin:2.2.2-SNAPSHOT")
		classpath(kotlin("gradle-plugin", version = "1.4.30"))
	}
}

allprojects {
	tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
		kotlinOptions.jvmTarget = "1.8"
	}
}

