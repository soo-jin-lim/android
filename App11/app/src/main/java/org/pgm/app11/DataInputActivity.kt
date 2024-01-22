package org.pgm.app11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pgm.app11.databinding.ActivityDataInputBinding
import org.pgm.app11.databinding.ActivityDetailBinding

class DataInputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding= ActivityDataInputBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnMain.setOnClickListener{
            val name=binding.editName.text.toString()
            val age=binding.editAge.text.toString().toInt()
            val phone=binding.editPhone.text.toString()
            intent.putExtra("name",name)
            intent.putExtra("age",age)
            intent.putExtra("phone",phone)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}