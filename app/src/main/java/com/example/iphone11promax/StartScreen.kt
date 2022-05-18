package com.example.iphone11promax

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class StartScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_screen)
    }
    fun get(view: View){
        val intent= Intent(this, LogInActivity::class.java)
        startActivity(intent)
    }
}