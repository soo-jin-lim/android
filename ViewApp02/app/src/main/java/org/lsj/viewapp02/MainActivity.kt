package org.lsj.viewapp02

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//
//        val name= TextView(this).apply {
//            typeface= Typeface.DEFAULT_BOLD//스타일은 볼드체
//            text="Lake Louise"//코드로 텍스트 뷰를 만듬
//        }//this?
//        val image= ImageView(this).also {
//            it.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.lake_1))
//        }
//        val address=TextView(this).apply {
//            typeface=Typeface.DEFAULT_BOLD
//            text="Lake Louise, AB,캐나다"
//        }
//        val layout=LinearLayout(this).apply {
//            orientation=LinearLayout.VERTICAL//수직으로 하겠다
//            gravity=Gravity.CENTER
//            addView(name,WRAP_CONTENT, WRAP_CONTENT) //내용물에 맞춰서 크기를 조절하겠다
//            addView(image, WRAP_CONTENT, WRAP_CONTENT)
//            addView(address, WRAP_CONTENT, WRAP_CONTENT)
//        }

        //this는 액티비티임 (내가 어디에 붙어야하는 대상)
        setContentView(R.layout.layout1)

        val ednum1:EditText=findViewById(R.id.ed01)
        val ednum2:EditText=findViewById(R.id.ed02)
        val btn: Button =findViewById(R.id.btn01)
        val resultTV:TextView=findViewById(R.id.tvResult)

        btn.setOnClickListener(View.OnClickListener {
            val num1:Int=ednum1.toString().toInt()
            val num2:Int=ednum2.toString().toInt()
            val result:Int=num1+num2

            resultTV.setText(result.toString())
        })
    }
}