package com.android.homeapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.TooltipCompat

class MainActivity : AppCompatActivity() {
    private val totalSeats = 100  // Use a meaningful variable name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonShowTooltip: Button = findViewById(R.id.buttonShowTooltip)
        val textView: TextView = findViewById(R.id.textView)
        val changeActivty: Button =findViewById(R.id.changeActivty)
        val thirdScreenActivity: Button =findViewById(R.id.changeActivtyid)
        // Calculate the number of free seats
        val freeSeats: Int = (totalSeats * 0.75).toInt()  // Corrected calculation

        // Set the tooltip text for the TextView
        TooltipCompat.setTooltipText(textView, "Click to show tooltip")

        buttonShowTooltip.setOnClickListener {
            showTooltip(buttonShowTooltip, "$freeSeats seats available (75% of 100)")  // Tooltip message
        }
        changeActivty.setOnClickListener {
            val intent = android.content.Intent(this, SecondActivity::class.java)
            startActivity(intent)

        }
        thirdScreenActivity.setOnClickListener {
            val intent = android.content.Intent(this, ThirdScreenActivity::class.java)
            startActivity(intent)
        }



    }

    private fun showTooltip(view: View, message: String) {
        // Set tooltip text when clicked
        TooltipCompat.setTooltipText(view, message)

        // Show the tooltip manually
        view.isSelected = true // This line helps trigger the tooltip appearance

        // Optionally, set a delay to remove the tooltip after a few seconds

        view.isSelected = false
        TooltipCompat.setTooltipText(view, message) // Clear the tooltip
        // Tooltip will disappear after 2 seconds
    }
}
