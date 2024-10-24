package com.android.homeapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.skydoves.balloon.ArrowPositionRules
import com.skydoves.balloon.Balloon
import com.skydoves.balloon.BalloonAnimation
import com.skydoves.balloon.BalloonSizeSpec

import kotlinx.coroutines.launch

class ThirdScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_screen)

        val changeActivityButton: Button = findViewById(R.id.changeActivtyid)

        changeActivityButton.setOnClickListener {
            val balloon = Balloon.Builder(applicationContext)
                .setWidthRatio(1.0f)
                .setHeight(BalloonSizeSpec.WRAP)
                .setText("Edit your profile here!")
                .setTextColorResource(android.R.color.white)
                .setTextSize(15f)
                .setIconDrawableResource(R.drawable.ic_chat)
                .setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
                .setArrowSize(10)
                .setArrowPosition(0.5f)
                .setPadding(12)
                .setCornerRadius(8f)
                .setBackgroundColorResource(android.R.color.holo_blue_light)
                .setBalloonAnimation(BalloonAnimation.ELASTIC)
                .setLifecycleOwner(this)
                .build()

            balloon.showAlignBottom(changeActivityButton)

            lifecycleScope.launch {
                balloon.dismissWithDelay(1000L) // dismisses 1000 milliseconds later when the popup is shown
            }
        }
    }
}
