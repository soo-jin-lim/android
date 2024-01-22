package org.pgm.app11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import org.pgm.app11.databinding.ActivityMainDataBinding

class MainDataActivity : AppCompatActivity() {
    var str1=""
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding=ActivityMainDataBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val requestLauncher:ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            val name=it.data?.getStringExtra("name")
            val age=it.data?.getIntExtra("age",0)
            val phone=it.data?.getStringExtra("phone")
            str1="이름 : $name \n"
            str1+="나이 : $age \n"
            str1+="연락처 : $phone \n"
            //binding.textView2.text=str1
        }
        binding.btnInput.setOnClickListener{
            val intent=Intent(this,DataInputActivity::class.java)
            requestLauncher.launch(intent)

        }
        binding.btnOutput.setOnClickListener{
            val intent=Intent(this,DataOutputActivity::class.java)
            intent.putExtra("str1",str1)
            startActivity(intent)
        }
    }
}