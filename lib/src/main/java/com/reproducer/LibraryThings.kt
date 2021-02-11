package com.reproducer

import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import javax.inject.Inject

abstract class AppScope private constructor()

class OkHttpClient @Inject constructor()

class Retrofit(private val client: OkHttpClient)

@Module
@ContributesTo(AppScope::class)
object RetrofitModule {

  @Provides
  fun provideRetrofit(
    lazyClient: dagger.Lazy<OkHttpClient>
  ): Retrofit = Retrofit(lazyClient.get())
}
