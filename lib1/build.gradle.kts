plugins {
  kotlin("jvm")
  id("com.squareup.anvil")
}

configure<com.squareup.anvil.plugin.AnvilExtension> {
	generateDaggerFactories = true
}

dependencies {
	implementation("com.google.dagger:dagger:2.34")
}
