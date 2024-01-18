package org.lsj.viewapp03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity2 : AppCompatActivity() {
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val chk:CheckBox=findViewById(R.id.cb1)
        val rg1:RadioGroup=findViewById(R.id.rg1)
        var rb1:RadioButton=findViewById(R.id)
        chk.setOnClickListener(View.OnClickListener {
            if(chk.isChecked){
                rg1.visibility=View.VISIBLE
            }else{
                rg1.visibility=View.INVISIBLE
            }
        })rb1.setOnclickListener(View.OnClickListener){
            iv1.visibility=View.VISIBLE



            iv2.visibility=view.Gone
        }

    }
}