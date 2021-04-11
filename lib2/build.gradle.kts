plugins {
  kotlin("jvm")
  kotlin("kapt")
  id("com.squareup.anvil")
}

dependencies {
	implementation("com.google.dagger:dagger:2.34")
	implementation(project(":lib1"))
	kapt("com.google.dagger:dagger-compiler:2.34")
}
