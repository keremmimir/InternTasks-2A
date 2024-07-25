package com.mobillium.interntasks2a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobillium.interntasks2a.databinding.ActivityNavigationBinding

class NavigationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}