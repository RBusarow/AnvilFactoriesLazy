pluginManagement {
  repositories {
    gradlePluginPortal()
    mavenCentral()
    jcenter()
  }
}

dependencyResolutionManagement {
  repositories {
    mavenCentral()
    google()
    jcenter()
  }
}

rootProject.name = "AnvilFactoriesLazy"

include(":lib1")
include(":lib2")
