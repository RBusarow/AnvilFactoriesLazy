package com.reproducer

interface QueueFlushSnackbarHelper {
  interface Factory {
    fun create(currentRoute: Class<out Route>): QueueFlushSnackbarHelper
  }
}

interface Route
