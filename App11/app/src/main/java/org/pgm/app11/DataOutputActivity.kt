package org.pgm.app11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pgm.app11.databinding.ActivityDataOutputBinding

class DataOutputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding=ActivityDataOutputBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val str1=intent.getStringExtra("str1")

        binding.textView3.text=str1

        binding.btnClose.setOnClickListener{
            finish()
        }
    }
}