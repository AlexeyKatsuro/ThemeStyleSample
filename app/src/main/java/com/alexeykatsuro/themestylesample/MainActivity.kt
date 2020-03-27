package com.alexeykatsuro.themestylesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_MyApp_Pro)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}