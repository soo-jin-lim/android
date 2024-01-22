package org.pgm.app11_pro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import org.pgm.app11_pro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var datas:MutableList<String>?= null
    lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        datas= mutableListOf()

        val requestLauncher:ActivityResultLauncher<Intent>
        =registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            it.data?.getStringExtra("result")?.let {
                datas?.add(it)
                adapter.notifyDataSetChanged()
            }
        }

        binding.mainFab.setOnClickListener{
            val intent=Intent(this, AddActivity::class.java)
            requestLauncher.launch(intent)
        }

        val layoutManager=LinearLayoutManager(this)
        binding.recyclerView1.layoutManager=layoutManager
        adapter= MyAdapter(datas)
        binding.recyclerView1.adapter=adapter
        binding.recyclerView1.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }
}









