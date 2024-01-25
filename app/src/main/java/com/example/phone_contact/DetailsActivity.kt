package com.example.phone_contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    var const=Constants()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        var name=intent.getStringExtra("name")
        val num=intent.getStringExtra("number")
        val description=intent.getStringExtra("description")
        var nameTV:TextView=findViewById(R.id.TVNameDetails)
        val numTV:TextView=findViewById(R.id.TVNumDetails)
        val descriptionTV:TextView=findViewById(R.id.TVDesDetails)

        nameTV.text= name
        numTV.text=num
        descriptionTV.text=description
    }
}




