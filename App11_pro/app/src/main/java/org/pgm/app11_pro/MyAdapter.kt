package org.pgm.app11_pro

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.pgm.app11_pro.databinding.ItemBinding

class MyViewholder(val binding:ItemBinding):RecyclerView.ViewHolder(binding.root)

class MyAdapter(val datas:MutableList<String>?):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewholder(ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return datas!!.size ?:0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding=(holder as MyViewholder).binding
        binding.textView.text=datas!![position]
    }
}