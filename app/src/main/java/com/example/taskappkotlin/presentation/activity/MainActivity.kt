package com.example.taskappkotlin.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.taskappkotlin.App
import com.example.taskappkotlin.R

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (applicationContext as App).shopComponent.inject(this)
        navController = Navigation.findNavController(this, R.id.nav_host)
    }
}