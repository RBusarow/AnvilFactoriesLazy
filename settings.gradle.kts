pluginManagement {
  repositories {
    gradlePluginPortal()
    mavenLocal()
    mavenCentral()
    jcenter()
  }
}

dependencyResolutionManagement {
  repositories {
    mavenLocal()
    mavenCentral()
    google()
    jcenter()
  }
}

rootProject.name = "AnvilReproducer"

include(":lib")
include(":app")
