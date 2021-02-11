package com.reproducer

import com.squareup.anvil.annotations.MergeComponent
import dagger.Component

@MergeComponent(scope = AppScope::class)
interface AppComponent {

  val retrofit: Retrofit

  @Component.Factory
  interface Factory {

    fun create(): AppComponent
  }
}
