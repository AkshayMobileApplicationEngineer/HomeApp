package com.android.homeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    private var fragmentManager: FragmentManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        fragmentManager = supportFragmentManager
        // Load the default fragment
        if (savedInstanceState == null) {
            fragmentManager!!.beginTransaction()
                .replace(R.id.fragment_container, MasterFragment())
                .commit()
        }
    }
}