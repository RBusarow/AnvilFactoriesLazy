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

rootProject.name = "AnvilFactoriesLazy"

include(":lib")
include(":app")
