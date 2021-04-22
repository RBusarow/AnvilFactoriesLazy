plugins {
  kotlin("jvm")
  kotlin("kapt")
  id("com.squareup.anvil")
}

dependencies {

  implementation(project(":lib"))
  implementation("com.google.dagger:dagger:2.32")

  kapt("com.google.dagger:dagger-compiler:2.32")
}
