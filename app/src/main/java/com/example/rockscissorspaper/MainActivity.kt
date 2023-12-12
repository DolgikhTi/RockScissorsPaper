package com.example.rockscissorspaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRock: Button = findViewById(R.id.btnRock)
        val btnScissors: Button = findViewById(R.id.btnScissors)
        val btnPaper: Button = findViewById(R.id.btnPaper)

        btnRock.setOnClickListener { playGame("rock") }
        btnScissors.setOnClickListener { playGame("scissors") }
        btnPaper.setOnClickListener { playGame("paper") }
    }

    private fun playGame(userChoice: String) {
        val choices = arrayOf("rock", "scissors", "paper")
        val computerChoice = choices.random()

        val result = when {
            userChoice == computerChoice -> "A Draw!"
            userChoice == "rock" && computerChoice == "scissors" ||
                    userChoice == "scissors" && computerChoice == "paper" ||
                    userChoice == "paper" && computerChoice == "rock" -> "Win!"
            else -> "Loss!"
        }

        val userMessage = "Your choice: $userChoice"
        val computerMessage = "Choosing a computer: $computerChoice"
        val resultMessage = "Result: $result"
        showToast(userMessage, computerMessage, resultMessage)
    }

    private fun showToast(message: String, message2: String, message3: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        Toast.makeText(this,message2, Toast.LENGTH_SHORT).show()
        Toast.makeText(this, message3, Toast.LENGTH_LONG).show()
    }
}