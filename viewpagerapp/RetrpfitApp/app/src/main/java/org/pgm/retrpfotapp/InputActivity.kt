package org.pgm.retrpfotapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.pgm.retrpfotapp.databinding.ActivityInputBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener{
            var userModel=UserModel(id=0,
            username=binding.editUsername.text.toString(),
            password = binding.editPass.text.toString(),
            roles=binding.editRole.text.toString())

            val networkService=(applicationContext as MyApplication).networkService
            val userInsertCall=networkService.insert(userModel)
            
            userInsertCall.enqueue(object : Callback<String>{
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    Log.d("aaaa","input success")
                    Log.d("aaaa",response.body().toString())
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.d("aaaa","input fail")
                    call.cancel()
                }
            })
            finish()
        }
    }
}