package com.android.homeapp

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.PopupWindowCompat
import com.nhaarman.supertooltips.ToolTip
import com.nhaarman.supertooltips.ToolTipRelativeLayout
import com.nhaarman.supertooltips.ToolTipView

class SecondActivity : AppCompatActivity(), ToolTipView.OnToolTipViewClickedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change) // Make sure you have the correct layout

        val button: Button = findViewById(R.id.your_button_id)
        val yourButtonId2: Button = findViewById(R.id.your_button_id_2)

        button.setOnClickListener {
            showTooltip(it, "Your tooltip text here")
        }

        val toolTipRelativeLayout =
            findViewById<View>(R.id.activity_main_tooltipRelativeLayout) as ToolTipRelativeLayout

        val toolTip = ToolTip()
            .withText("A beautiful View")
            .withColor(Color.RED)
            .withShadow()
            .withAnimationType(ToolTip.AnimationType.FROM_TOP)

        val myToolTipView: ToolTipView? = toolTipRelativeLayout.showToolTipForView(
            toolTip, findViewById<View>(R.id.activity_main_redtv)
        )
        myToolTipView?.setOnToolTipViewClickedListener(this)
    }

    private fun showTooltip(anchorView: View, tooltipText: String) {
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.tooltip_layout, null)

        val tooltipTextView: TextView = popupView.findViewById(R.id.tooltip_text)
        tooltipTextView.text = tooltipText

        val popupWindow = PopupWindow(
            popupView,
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        popupWindow.isOutsideTouchable = true
        popupWindow.isFocusable = true
        PopupWindowCompat.setOverlapAnchor(popupWindow, true)

        val backgroundDrawable = ContextCompat.getDrawable(this, R.drawable.tooltip_background)
        popupWindow.setBackgroundDrawable(backgroundDrawable)

        // Show the tooltip
        popupWindow.showAsDropDown(anchorView, 0, -anchorView.height)
    }

    override fun onToolTipViewClicked(toolTipView: ToolTipView?) {
        toolTipView?.remove()
    }
}
