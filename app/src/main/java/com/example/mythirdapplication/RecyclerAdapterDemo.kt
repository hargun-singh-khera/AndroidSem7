package com.example.mythirdapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapterDemo(var list: MutableList<MyDataModel1>): RecyclerView.Adapter<RecyclerAdapterDemo.MyHolderDemo>() {
    class MyHolderDemo(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title:TextView = itemView.findViewById(R.id.title)
        var genre:TextView = itemView.findViewById(R.id.genre)
        var year:TextView = itemView.findViewById(R.id.year)
        var delete:Button = itemView.findViewById(R.id.deleteBtn)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolderDemo {
        var inflator = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerdemolayout,parent,false)
        return MyHolderDemo(inflator)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolderDemo, position: Int) {
        val data = list[position]
        holder.title.text = data.getTitle()
        holder.genre.text = data.getGenre()
        holder.year.text = data.getYear()
        holder.delete.setOnClickListener {
            val itemSelected = list.get(position)
            list.remove(itemSelected)
            notifyDataSetChanged()
        }
    }
}