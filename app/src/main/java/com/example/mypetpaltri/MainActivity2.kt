package com.example.mypetpaltri

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var feedProgress: ProgressBar
    private lateinit var sleepProgress: ProgressBar
    private lateinit var playProgress: ProgressBar
    private lateinit var imageViewDead: ImageView

    private fun setButtonListeners() {
        findViewById<Button>(R.id.FEEDbtn).setOnClickListener {
            // Simulate action and increase progress
            feedProgress.incrementProgressBy(10)
            checkPetHealth()
        }
        findViewById<Button>(R.id.SLEEPbtn).setOnClickListener {
            // Simulate action and increase progress
            sleepProgress.incrementProgressBy(10)
            checkPetHealth()
        }
        findViewById<Button>(R.id.PLAYbtn).setOnClickListener {
            // Simulate action and increase progress
            playProgress.incrementProgressBy(10)
            checkPetHealth()
        }
    }

    private fun checkPetHealth() {
        if (feedProgress.progress <= 0 && sleepProgress.progress <= 0 && playProgress.progress <= 0) {
            imageViewDead.visibility = ImageView.VISIBLE
            Toast.makeText(this, "Your pet has died.", Toast.LENGTH_LONG).show()
            // Start a short delay before exiting
            object : CountDownTimer(5000, 1000) {
                override fun onFinish() {
                    navigateBackToFirstActivity()
                }

                override fun onTick(millisUntilFinished: Long) {
                    // Can be used to show a countdown timer
                }
            }.start()
        }
    }

    private fun navigateBackToFirstActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()  // End this activity
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Initialize progress bars
        feedProgress = findViewById(R.id.feedProgress)
        sleepProgress = findViewById(R.id.sleepProgress)
        playProgress = findViewById(R.id.playProgress)

        // Initialize image for dead dragon
        imageViewDead = findViewById(R.id.imageViewDead)

        // Set onClickListeners for feeding, sleeping, and playing
        setButtonListeners()

        // Set onClickListener for back button
        findViewById<Button>(R.id.backbtn).setOnClickListener {
            finish()
        }
    }
}
