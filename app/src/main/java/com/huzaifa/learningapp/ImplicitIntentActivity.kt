package com.huzaifa.learningapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ImplicitIntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_implicit_intent)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val openWebPageButton = findViewById<Button>(R.id.openWebPage);
        val openPhoneCallButton = findViewById<Button>(R.id.openPhoneCall);
        val openCameraButton = findViewById<Button>(R.id.openCamera);
        val shareButton = findViewById<Button>(R.id.shareButton);

        openWebPageButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.huzaifa.uno/"))
            startActivity(intent);
        }

        openPhoneCallButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL);
            intent.data = Uri.parse("tel:+123456789");
            startActivity(intent);
        }

        openCameraButton.setOnClickListener{
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        }

        shareButton.setOnClickListener{
            val textField = findViewById<EditText>(R.id.textField);
            val text = textField.text.toString()
            val intent = Intent(Intent.ACTION_SEND);
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT,text);
            startActivity(Intent.createChooser(intent,"Share Via"))

        }
    }
}