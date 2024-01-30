package org.pgm.retrpfotapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Response
import org.pgm.retrpfotapp.databinding.ActivityRetrofitMqainBinding
import retrofit2.Call
import retrofit2.Callback
import java.net.CacheResponse

class RetrofitMqainActivity : AppCompatActivity() {
    lateinit var binding:ActivityRetrofitMqainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityRetrofitMqainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener{
            val intent= Intent(this, InputActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onStart() {
        super.onStart()

        val networkService=(applicationContext as MyApplication).networkService
        val userListCall=networkService.doGetUserList()
        userListCall.enqueue(object: Callback<UserListModel>{
            override fun onResponse(
                call: Call<UserListModel>,
                response: retrofit2.Response<UserListModel>
            ) {
                if(response.isSuccessful){
                    Log.d("aaaa","success")
                    binding.recyclerView1.layoutManager=LinearLayoutManager(this@RetrofitMqainActivity)
                    val userList=response.body()?.users
                    Log.d("aaaa","${response.body()?.users?.size}")
                    val adapter=MyAdapter(this@RetrofitMqainActivity, response.body()?.users)
                    binding.recyclerView1.adapter=adapter
                    binding.recyclerView1.addItemDecoration(
                        DividerItemDecoration(this@RetrofitMqainActivity, LinearLayoutManager.VERTICAL)
                    )
                }
            }

            override fun onFailure(call: Call<UserListModel>, t: Throwable) {
                Log.d("aaaaa","fail")
                call.cancel()
            }
        })
    }
}