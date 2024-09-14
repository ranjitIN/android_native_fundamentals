package com.example.layout

import android.content.Intent
import android.os.Bundle
import android.util.Log

import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.layout.models.Person

class SecondActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var butonBack:Button = findViewById(R.id.btBack);
        var nextButton:Button = findViewById(R.id.btSecondNext)
        nextButton.setOnClickListener {
            Intent(this,ThirdActivity::class.java).also {
                startActivity(it)
            }
        }
        var person:Person = intent.getSerializableExtra("EXTRA_PERSON") as Person
        butonBack.setOnClickListener {
            Log.i("Second Activity", person.toString())
//            finish();
        }
    }
}