package com.anandarezakurniawan_19104061.helloittelkompurwokerto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class Halaman2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman2)
    }

    fun printState(msg : String){
        Log.d("ActivituState", msg) // Logcat, muncul di logcat Android Studio
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show() // Toast, muncul di UI aplikasi
    }

    override fun onStart() {
        super.onStart()
        printState("Halaman dua onStart")
    }

    override fun onResume() {
        super.onResume()
        printState("Halaman dua onResume")
    }

    override fun onPause() {
        super.onPause()
        printState("Halaman dua onPause")
    }

    override fun onStop() {
        super.onStop()
        printState("Halaman dua onStop")
    }

    override fun onRestart() {
        super.onRestart()
        printState("Halaman dua onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        printState("Halaman dua onDestroy")
    }
}