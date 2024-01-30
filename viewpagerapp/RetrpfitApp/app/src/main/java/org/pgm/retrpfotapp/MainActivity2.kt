package org.pgm.retrpfotapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.pgm.retrpfotapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding:ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val queue=Volley.newRequestQueue(this)

        binding.button.setOnClickListener{
            val stringRequest=StringRequest(
                Request.Method.GET,
                "http://10.100.105.213:8082/api/home",
                Response.Listener<String>{
                    binding.textView.text="$it"
                },
                Response.ErrorListener { error->
                    binding.textView.text="$it"
                }
            )
            queue.add(stringRequest)
        }
    }
}