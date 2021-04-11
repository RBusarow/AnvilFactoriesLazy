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
