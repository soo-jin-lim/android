package org.pgm.retrpfotapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.pgm.retrpfotapp.databinding.ActivityDetail3Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityDetail3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val id=intent.getLongExtra("id",0)
        val username=intent.getStringExtra("username")
        val networkService=(applicationContext as MyApplication).networkService

        val userModelCall=networkService.doGetUserId(id)
        userModelCall.enqueue(object : Callback<UserModel>{
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                val userModel=response.body()
                binding.tvUser.text="""id:${userModel?.id},
                        "username:${userModel?.username},
                         "password:${userModel?.password},
                         "roles:${userModel?.roles}
                        """
            }
            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                Log.d("aaaa", "fail")
                call.cancel()
            }

        })


    }
}