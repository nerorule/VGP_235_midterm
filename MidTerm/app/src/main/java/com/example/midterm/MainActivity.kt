package com.example.midterm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var profilePic: ImageView

    // waits for result from ExploreActivity
    private val exploreLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

            if (result.resultCode == RESULT_OK) {

                val imageSelected =
                    result.data?.getIntExtra("selectedImage", R.drawable.guy)

                if (imageSelected != null) {
                    profilePic.setImageResource(imageSelected)
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        profilePic = findViewById(R.id.Profile_Pic_id)

        val userButton = findViewById<Button>(R.id.buttonuser_id)

        userButton.setOnClickListener {

            val intent = Intent(this, ExploreActivity::class.java)
            exploreLauncher.launch(intent)
        }
    }
}