plugins {
	kotlin("jvm")
	id("com.squareup.anvil")
}

configure<com.squareup.anvil.plugin.AnvilExtension> {
	generateDaggerFactories = true // default is false
}

dependencies {
	implementation("com.google.dagger:dagger:2.32")
}
