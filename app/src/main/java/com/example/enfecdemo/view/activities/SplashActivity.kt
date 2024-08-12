package com.example.enfecdemo.view.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * This is the starting point of the app. Looking at the manifest.xml, you should see that this
 * Activity has the Launcher and Main Intent flags associated with it. This is how you tell the
 * OS which Class to open first.
 *
 * Follow the tutorial listed in the README on how to implement this.
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()


    }
}
