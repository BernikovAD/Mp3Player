package com.example.mp3player.model

import android.os.Environment
import android.system.Os.accept
import android.util.Log
import java.io.File
import java.net.URLConnection
import java.util.ArrayList

class Model {
    private val path = Environment.getExternalStorageDirectory().toString() + "/Download/"
    val directory: File = File(path)
    fun getPath():String = path
    val listMusic:MutableList<String> = ArrayList()
    val files = directory.listFiles()

    //Считываем директорию и записываем ее в List
    fun readDir() : List<String>{
        Log.i("MyLog","Выполняется ReadDir")
        if(files !=null){
            for (file in files)run {
                val mimeType = URLConnection.guessContentTypeFromName(file.name)
                if (mimeType != null && mimeType.indexOf("audio") == 0) {
                    listMusic.add(file.name)
                }
            }
        }
        return listMusic
    }
}