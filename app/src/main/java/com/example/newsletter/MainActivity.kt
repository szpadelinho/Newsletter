package com.example.newsletter

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var name = ""
    var email = ""
    var news = ""
    var sport = ""
    var tech = ""
    var frequency = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nameObj = findViewById<EditText>(R.id.name)
        val emailObj = findViewById<EditText>(R.id.mail)

        val image = findViewById<ImageView>(R.id.the_image)

        val checkedNews = findViewById<CheckBox>(R.id.news)
        val checkedSport = findViewById<CheckBox>(R.id.sport)
        val checkedTech = findViewById<CheckBox>(R.id.tech)

        checkedNews.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                news = "Wybrano wiadomosci."
                image.setImageResource(R.drawable.news)
            }
            else{
                news = ""
                image.setImageResource(R.drawable.apple_cat)
            }
        }
        checkedSport.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                sport = "Wybrano sport."
                image.setImageResource(R.drawable.sports)
            }
            else{
                sport = ""
                image.setImageResource(R.drawable.apple_cat)
            }
        }
        checkedTech.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                tech = "Wybrano technologię."
                image.setImageResource(R.drawable.techs)
            }
            else{
                tech = ""
                image.setImageResource(R.drawable.apple_cat)
            }
        }

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        radioGroup.setOnCheckedChangeListener { _, isChecked ->
            val radioButton = findViewById<RadioButton>(isChecked)
            frequency = radioButton.text.toString()
        }

        val submit = findViewById<Button>(R.id.submit)
        val info = findViewById<TextView>(R.id.info)

        submit.setOnClickListener{
            name = nameObj.text.toString()
            email = emailObj.text.toString()

            info.text = "Czesc $name. Twoj email to $email. $news $sport $tech Wiadomosci beda przesylane $frequency."
        }
    }
}