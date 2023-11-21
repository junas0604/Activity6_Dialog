package com.gutib.dialogexplorer.gutibjunasnazarito_activity6_dialogexplorer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gutib.dialogexplorer.gutibjunasnazarito_activity6_dialogexplorer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.proceed.setOnClickListener {
            startActivity(Intent(this, SecondPage::class.java))
            finish()
        }



    }
}