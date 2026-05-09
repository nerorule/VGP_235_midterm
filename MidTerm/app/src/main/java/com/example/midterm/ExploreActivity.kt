package com.example.midterm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ExploreActivity : AppCompatActivity() {

    private var selectedImage = R.drawable.guy

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_explore)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Images
        val imageGuy = findViewById<ImageView>(R.id.imageguy_id)
        val imageAnime = findViewById<ImageView>(R.id.imageanime_id)
        val imagePanda = findViewById<ImageView>(R.id.imagepanda_id)
        val imageHappy = findViewById<ImageView>(R.id.imagehappy_id)
        val imageDragon = findViewById<ImageView>(R.id.imagedragon_id)

        // EditTexts
        val editName = findViewById<EditText>(R.id.edittTextName_id)
        val editOccupation = findViewById<EditText>(R.id.editTextOcupation_id)
        val editHeight = findViewById<EditText>(R.id.editTextHeight_id)
        val editWeight = findViewById<EditText>(R.id.editTextWeight_id)
        val editAge = findViewById<EditText>(R.id.editTextAge_id)
        val editEyeColor = findViewById<EditText>(R.id.editTextEyeColor_id)
        val editHairColor = findViewById<EditText>(R.id.editTextHairColor_id)
        val editBodyType = findViewById<EditText>(R.id.editTextBodyType_id)

        // Button
        val saveButton = findViewById<Button>(R.id.buttonSave_id)

        // Image Selection
        imageGuy.setOnClickListener {
            selectedImage = R.drawable.guy
        }

        imageAnime.setOnClickListener {
            selectedImage = R.drawable.anime
        }

        imagePanda.setOnClickListener {
            selectedImage = R.drawable.panda
        }

        imageHappy.setOnClickListener {
            selectedImage = R.drawable.happy
        }

        imageDragon.setOnClickListener {
            selectedImage = R.drawable.dragon
        }

        // Save Button
        saveButton.setOnClickListener {

            // Save preferences
            UserPreferences.name = editName.text.toString()
            UserPreferences.occupation = editOccupation.text.toString()
            UserPreferences.height = editHeight.text.toString()
            UserPreferences.weight = editWeight.text.toString()
            UserPreferences.age = editAge.text.toString()
            UserPreferences.eyeColor = editEyeColor.text.toString()
            UserPreferences.hairColor = editHairColor.text.toString()
            UserPreferences.bodyType = editBodyType.text.toString()

            // Open UserActivity
            val intent = Intent(this, UserActivity::class.java)

            intent.putExtra("selectedImage", selectedImage)

            startActivity(intent)
        }
    }
}