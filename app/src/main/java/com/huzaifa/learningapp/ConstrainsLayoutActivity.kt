package com.huzaifa.learningapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.shashank.sony.fancytoastlib.FancyToast

class ConstrainsLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_constrains_layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Toast Stuff:
        val toastButton = findViewById<Button>(R.id.button3);
        val toastButton2 = findViewById<Button>(R.id.button4);

        toastButton.setOnClickListener{
            println("Button 3 Pressed");
            Toast.makeText(this, "This is toast", Toast.LENGTH_SHORT).show()
        }

        toastButton2.setOnClickListener {
            FancyToast.makeText(this,"This is fancy toast",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show()
        }
    }
}