package org.lsj.fragmentapp01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import org.lsj.fragmentapp01.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)

        binding.button.setOnClickListener{
            val fragmentManager:FragmentManager=supportFragmentManager
            val transaction:FragmentTransaction=fragmentManager.beginTransaction()
            val fragment=OneFragment()
            transaction.replace(R.id.fragment_contaniner,fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.button2.setOnClickListener{
            val fragmentManager:FragmentManager=supportFragmentManager
            val transaction:FragmentTransaction=fragmentManager.beginTransaction()
            val fragment=TwoFragment()
            transaction.replace(R.id.fragment_contaniner,fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.button3.setOnClickListener{
            val fragmentManager:FragmentManager=supportFragmentManager
            val transaction:FragmentTransaction=fragmentManager.beginTransaction()
            val fragment=ThreeFragment()
            transaction.replace(R.id.fragment_contaniner,fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        val fragmentManager:FragmentManager=supportFragmentManager
        val transaction:FragmentTransaction=fragmentManager.beginTransaction()
        val fragment=OneFragment()
        transaction.add(R.id.fragment_contaniner,fragment)
        transaction.commit()
    }

    override fun onClick(v: View){
        val fragmentManager:FragmentManager=supportFragmentManager
        val transaction:FragmentTransaction=fragmentManager.beginTransaction()
        var fragment:Fragment
        when(v?.id){
            R.id.button ->{
                val fragment:OneFragment=OneFragment()
                transaction.replace(R.id.fragment_contaniner,fragment)
            }
            R.id.button2 ->{
                val fragment:TwoFragment=TwoFragment()
                transaction.replace(R.id.fragment_contaniner,fragment)
            }
            R.id.button3 ->{
                val fragment:ThreeFragment=ThreeFragment()
                transaction.replace(R.id.fragment_contaniner,fragment)
            }
        }
        transaction.addToBackStack(null)
        transaction.commit()
    }


}