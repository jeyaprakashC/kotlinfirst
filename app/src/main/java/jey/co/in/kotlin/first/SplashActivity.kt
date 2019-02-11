package jey.co.`in`.kotlin.first

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import jey.co.`in`.kotlin.first.home.DashBoardActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            val listIntent = Intent(this@SplashActivity, DashBoardActivity::class.java);
            startActivity(listIntent)
        }, 3000)
    }
}
