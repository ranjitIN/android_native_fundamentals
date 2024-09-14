package com.example.layout

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
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

        var firstName:EditText = findViewById(R.id.etFirstName)
        var lastName:EditText = findViewById(R.id.etLastName)
        var age:EditText = findViewById(R.id.etAge)
        var country:EditText = findViewById(R.id.etCountry)
        var submitButton:Button = findViewById(R.id.btSubmit)

        submitButton.setOnClickListener {
            var person:Person = Person(firstName.text.toString(),lastName.text.toString(),age.text.toString().toInt(),country.text.toString())
            Log.i("MainActvity", person.toString())

          Intent(this,SecondActivity::class.java).also {
              it.putExtra("EXTRA_PERSON", person)
              startActivity(it)
          }
        }

    }
}