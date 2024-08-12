package com.example.enfecdemo

import android.app.Application
import timber.log.Timber

/**
 * Overridden Application class to initialize certain libraries at a higher level than just a
 * Fragment or Activity.
 *
 * In the Manifest, this class will be listed under the Application tag in the name field.
 */
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}
