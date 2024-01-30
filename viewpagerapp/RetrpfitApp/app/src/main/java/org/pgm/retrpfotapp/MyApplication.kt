package org.pgm.retrpfotapp

import android.app.Application
import com.bumptech.glide.Glide.init
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication :Application() {
    var networkService:INetworkService
    val retrofit:Retrofit
        get()=Retrofit.Builder()
            .baseUrl("http://10.100.105.213:8082/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    init{
        networkService=retrofit.create(INetworkService::class.java)
    }
}