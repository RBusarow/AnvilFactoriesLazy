package com.reproducer.other

import com.reproducer.AppScope
import com.reproducer.QueueFlushSnackbarHelper
import com.reproducer.Route
import com.squareup.anvil.annotations.ContributesBinding
import com.squareup.anvil.annotations.MergeComponent
import javax.inject.Inject

class ISPSQFlushSnackbarHelper private constructor(
  // / other imports
  private val currentRoute: Class<out Route>
) : QueueFlushSnackbarHelper {
  @ContributesBinding(AppScope::class, boundType = QueueFlushSnackbarHelper.Factory::class)
  class Factory @Inject constructor( /*injections*/) : QueueFlushSnackbarHelper.Factory {
    override fun create(
      currentRoute: Class<out Route>
    ): QueueFlushSnackbarHelper = ISPSQFlushSnackbarHelper(TODO())
  }
}

@MergeComponent(AppScope::class)
interface AppComponent {
  val fact: QueueFlushSnackbarHelper.Factory
}
