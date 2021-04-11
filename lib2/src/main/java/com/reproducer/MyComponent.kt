package com.reproducer

import dagger.BindsInstance
import dagger.Component
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
@Component
interface MyComponent{

  val ic: Provider<InjectClass>

  @Component.Factory
  interface Factory {

    fun create(
      @BindsInstance
     string: String
    ): MyComponent
  }
}

fun main() {

  val component = DaggerMyComponent.factory().create("hello")

  val injectClass = component.ic.get()

  // should not crash
  println(injectClass.stringProvider.get())

}
