package com.example.dialogfragment

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var show: Button
    lateinit var name: TextView
    lateinit var age: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        show = findViewById(R.id.buttonShow)
        name = findViewById(R.id.textViewName)
        age = findViewById(R.id.textViewAge)

        show.setOnClickListener{

            val fragmentManager: FragmentManager = supportFragmentManager
            val myDIalogFragment = MyDIalogFragment()

            myDIalogFragment.show(fragmentManager,"MyDialogFragment")

        }

    }

    fun getUserData(userName: String, userAge: Int){
        name.text = "Name: $userName"
        age.text = "Age:$userAge"
    }
}