package com.huzaifa.learningapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ShareBundleToActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_share_bundle_to)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val firstName = findViewById<TextView>(R.id.showFName);
        val lastName = findViewById<TextView>(R.id.showLName);
        val rollNo = findViewById<TextView>(R.id.showRollNo);
        val phoneNo = findViewById<TextView>(R.id.showPhoneNo);

        val intent = intent;
        val fName = intent.getStringExtra("firstName")
        val lName = intent.getStringExtra("lastName")
        val rollNum = intent.getStringExtra("rollNo")
        val phoneNum = intent.getStringExtra("phoneNo")

        firstName.text = "First Name: $fName";
        lastName.text = "Last Name: $lName";
        rollNo.text = rollNum;
        phoneNo.text = phoneNum;
    }
}