package com.reproducer

import javax.inject.Inject
import javax.inject.Provider

class InjectClass @Inject constructor(
  val string: String
) {

  @Inject lateinit var stringProvider: Provider<String>
}

