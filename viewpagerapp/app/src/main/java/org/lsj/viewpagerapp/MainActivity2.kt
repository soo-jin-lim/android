package org.lsj.viewpagerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.lsj.viewpagerapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPage2.adapter=MyfragmentAdapter(this)
    }
}

class MyfragmentAdapter(activity: FragmentActivity):FragmentStateAdapter(activity) {
    val fragments:List<Fragment>
    init {
        fragments= listOf(OneFragment(), TwoFragment(), ThreeFragment())
    }
    override fun getItemCount(): Int {
        TODO("Not yet implemented")
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}