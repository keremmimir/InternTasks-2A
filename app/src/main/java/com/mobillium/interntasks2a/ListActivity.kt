package com.mobillium.interntasks2a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobillium.interntasks2a.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}