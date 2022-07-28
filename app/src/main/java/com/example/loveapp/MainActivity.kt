package com.example.loveapp

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.loveapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val win: Window = window
        win.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val navController = findNavController(R.id.nav_host_fragment)
        navController.navigate(R.id.boardFragment)

    }


}