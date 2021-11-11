package com.anandarezakurniawan_19104061.helloittelkompurwokerto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPage = findViewById<Button>(R.id.btn_page)
        btnPage.setOnClickListener {
            val intent = Intent(this, Halaman2Activity::class.java)
            startActivity(intent)
        }
    }

    fun printState(msg : String){
        Log.d("ActivityState", msg) // Logcat, muncul di logcat Android Studio
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show() // Toast, muncul di UI aplikasi
    }

    override fun onStart() {
        super.onStart()
        printState("Halaman satu onStart")
    }

    override fun onResume() {
        super.onResume()
        printState("Halaman Satu onResume")
    }

    override fun onPause() {
        super.onPause()
        printState("Halaman Satu onPause")
    }

    override fun onStop() {
        super.onStop()
        printState("Halaman Satu onStop")
    }

    override fun onRestart() {
        super.onRestart()
        printState("Halaman Satu onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        printState("Halaman Satu onDestroy")
    }
}