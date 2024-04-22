package com.example.myquiz.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import com.example.myquiz.R
import com.example.myquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val window: Window = this@MainActivity.window
        window.statusBarColor=ContextCompat.getColor(this@MainActivity, R.color.gray)

        binding.apply {
            menu.setItemSelected(R.id.home)
            menu.setOnItemSelectedListener {
                if (it == R.id.ranking) {
                    startActivity(Intent(this@MainActivity, LeaderActivity::class.java))
                }
            }
        }
    }
}