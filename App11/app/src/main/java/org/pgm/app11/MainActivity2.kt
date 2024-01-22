package org.pgm.app11

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pgm.app11.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGoogle.setOnClickListener{
            val intent= Intent().apply{
                action=Intent.ACTION_CALL
                data=Uri.parse("010-1234-4567")
            }
            startActivity(intent)
        }
    }
}