package com.example.uts_if10k_10120917_ristian_aditya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private val splash = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        android.os.Handler().postDelayed({
            val intent = Intent(this@MainActivity, WalkTroughActivity::class.java)
            startActivity(intent)
            finish()
        }, splash.toLong())
    }
}