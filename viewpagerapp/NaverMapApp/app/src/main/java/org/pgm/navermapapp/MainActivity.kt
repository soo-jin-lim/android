package org.pgm.navermapapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pgm.navermapapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button1.setOnClickListener{
            val intent= Intent(this, Map1Activity::class.java)
            startActivity(intent)
        }

        binding.button2.setOnClickListener{
            val intent= Intent(this, MapTranActivity::class.java)
            startActivity(intent)
        }

        binding.button3.setOnClickListener{
            val intent= Intent(this, MapViewActivity::class.java)
            startActivity(intent)
        }
    }
}







