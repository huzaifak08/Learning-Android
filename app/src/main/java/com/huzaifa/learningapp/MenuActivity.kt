package com.huzaifa.learningapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    val customMenu = com.huzaifa.learningapp.CustomMenu();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val showPopUp = findViewById<Button>(R.id.button6)
        showPopUp.setOnClickListener {
            customMenu.showCustomMenu(this,it);
        }

        var dialog = AlertDialog.Builder(this);

        dialog.setTitle("Delete File")
        dialog.setMessage("Do you want to delete it?")
        dialog.setIcon(R.drawable.keyboard_arrow_right_12)

        dialog.setPositiveButton("Yes"){dialogInterface,which ->
            Toast.makeText(
                this,
                "Clicked Yes",
                Toast.LENGTH_SHORT
            ).show()}

        dialog.setNegativeButton("Yes"){dialogInterface,which ->
            Toast.makeText(
                this,
                "Clicked Yes",
                Toast.LENGTH_SHORT
            ).show()}

        dialog.setNeutralButton("Yes"){dialogInterface,which ->
            Toast.makeText(
                this,
                "Clicked Yes",
                Toast.LENGTH_SHORT
            ).show()}

        val alertDialog:AlertDialog = dialog.create();
        alertDialog.setCancelable(false);
        alertDialog.show();
    }
}