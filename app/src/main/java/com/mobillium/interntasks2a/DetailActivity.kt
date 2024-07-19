package com.mobillium.interntasks2a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobillium.interntasks2a.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textCity.text=intent.getStringExtra("city")
        binding.image.setImageResource(intent.getIntExtra("image",0))
        binding.textWeatherDegree.text=intent.getStringExtra("weather_degree")
        binding.textWeather.text=intent.getStringExtra("weather")


    }
}