package com.example.mp3player.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mp3player.databinding.FragmentListMusicBinding
import com.example.mp3player.model.Model


class FragmentListMusic : Fragment() {
    private var _binding: FragmentListMusicBinding? = null
    private val binding: FragmentListMusicBinding
        get() = _binding!!
    var model:Model = Model()
    val listMusic:MutableList<String> = model.readDir() as MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentListMusicBinding.inflate(inflater, container, false)

        //отправояем команду презентору чтобы тот вернул список файлов и отправляем все в адаптер, чтоб отобразить на экране
        val itemMusicFileAdapter = AdapterListMusic(listMusic)
        binding.recyclerViewListMusic.layoutManager = LinearLayoutManager(activity)
        binding.recyclerViewListMusic.adapter = itemMusicFileAdapter
        return binding.root
    }

    companion object { fun newInstance() = FragmentListMusic() }
}



