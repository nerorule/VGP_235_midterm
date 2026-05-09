package com.example.midterm

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Random Lists
        val names = listOf("Martha", "John", "Liz")
        val occupations = listOf("banker", "cashier", "profesor")
        val eyeColors = listOf("blue", "green", "brown")
        val hairColors = listOf("brown", "black", "brunnete")
        val bodyTypes = listOf("slim", "medium", "heavy")

        // Random Values
        val randomName = names.random()
        val randomOccupation = occupations.random()
        val randomHeight = Random.nextInt(150, 201)
        val randomWeight = Random.nextInt(50, 121)
        val randomAge = Random.nextInt(18, 50)
        val randomEyeColor = eyeColors.random()
        val randomHairColor = hairColors.random()
        val randomBodyType = bodyTypes.random()

        // TextViews
        val textName = findViewById<TextView>(R.id.textViewName_id)
        val textOccupation = findViewById<TextView>(R.id.textViewOcupation_id)
        val textHeight = findViewById<TextView>(R.id.textViewHeight_id)
        val textWeight = findViewById<TextView>(R.id.textViewWeight_id)
        val textAge = findViewById<TextView>(R.id.textViewAge_id)
        val textEyeColor = findViewById<TextView>(R.id.textViewEyeColor_id)
        val textHairColor = findViewById<TextView>(R.id.textViewHairColor_id)
        val textBodyType = findViewById<TextView>(R.id.textViewBodyType_id)
        val textPercentage = findViewById<TextView>(R.id.textView_Porcentage_id)

        // Display Random Profile
        textName.text = randomName
        textOccupation.text = randomOccupation
        textHeight.text = randomHeight.toString()
        textWeight.text = randomWeight.toString()
        textAge.text = randomAge.toString()
        textEyeColor.text = randomEyeColor
        textHairColor.text = randomHairColor
        textBodyType.text = randomBodyType

        // Match System
        var matches = 0
        var total = 5

        if (UserPreferences.occupation.lowercase() == randomOccupation.lowercase()) {
            matches++
        }

        if (UserPreferences.eyeColor.lowercase() == randomEyeColor.lowercase()) {
            matches++
        }

        if (UserPreferences.hairColor.lowercase() == randomHairColor.lowercase()) {
            matches++
        }

        if (UserPreferences.bodyType.lowercase() == randomBodyType.lowercase()) {
            matches++
        }

        // Weight Comparison
        val userWeight = UserPreferences.weight.toIntOrNull()

        if (userWeight != null) {

            val difference = kotlin.math.abs(userWeight - randomWeight)

            if (difference <= 10) {
                matches++
            }
        }

        // Percentage
        val percentage = (matches.toDouble() / total.toDouble()) * 100

        textPercentage.text = "${percentage.toInt()}%"
    }
}