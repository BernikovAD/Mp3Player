package com.example.mp3player.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mp3player.R

class AdapterListMusic(listMusic: MutableList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<String>? = listMusic



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return object : RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        ) {}
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val name = holder.itemView.findViewById<TextView>(R.id.name_music_file)
        name.text = String.format("%s", items!![position])
    }

    override fun getItemCount(): Int = items?.size!!

}