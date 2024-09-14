package com.example.layout

import android.app.Activity
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.layout.models.Person

class MainActivity : AppCompatActivity() {
    var TAG = "MainActivity";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var addImage:Button = findViewById<Button>(R.id.btAddImage)

        addImage.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.setType("image/*")
                startActivityForResult(it,0);
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == 0){
            Log.i("MainActivity",data.toString())
            var uri = data?.data;
            var imageViewer:ImageView = findViewById(R.id.idImageView)
            imageViewer.setImageURI(uri)
        }
    }
}