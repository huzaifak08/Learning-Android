package com.huzaifa.learningapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ShareBundleFromActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_share_bundle_from)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val firstName = findViewById<EditText>(R.id.firstName);
        val lastName = findViewById<EditText>(R.id.lastName);
        val rollNo = findViewById<EditText>(R.id.rollNo);
        val phoneNo = findViewById<EditText>(R.id.phoneNo);
        val goButton = findViewById<Button>(R.id.goButton);

        goButton.setOnClickListener {
            val fName = firstName.text.toString();
            val lName = lastName.text.toString();
            val rollNum = rollNo.text.toString();
            val phoneNum = phoneNo.text.toString();

            val intent = Intent(this,ShareBundleToActivity::class.java);
            intent.putExtra("firstName",fName);
            intent.putExtra("lastName",lName);
            intent.putExtra("rollNo",rollNum);
            intent.putExtra("phoneNo",phoneNum);
            startActivity(intent);

        }
    }
}