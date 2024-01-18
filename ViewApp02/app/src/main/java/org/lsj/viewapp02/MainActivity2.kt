package org.lsj.viewapp02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val btn1:Button=findViewById(R.id.btnHide)
        val btn2:Button=findViewById(R.id.btnHide)
        val image:ImageView=findViewById(R.id.iv)

        btn1.setOnClickListener(View.OnClickListener {
            image.visibility=View.VISIBLE
        })
        btn2.setOnClickListener(View.OnClickListener {
            image.visibility=View.GONE
        })
    }
}