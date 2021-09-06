package com.example.mp3player.view

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mp3player.R

class MainActivity : AppCompatActivity() {
    private val MY_PERMISSIONS_REQUEST_READ_STORAGE = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), MY_PERMISSIONS_REQUEST_READ_STORAGE)
        } else {
             init()
        }
    }

    fun init(){
            supportFragmentManager.beginTransaction().replace(R.id.fragment_list_music, FragmentListMusic.newInstance()).commit()
    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String?>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if ((requestCode == MY_PERMISSIONS_REQUEST_READ_STORAGE)
            && (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) init()
    }
}


