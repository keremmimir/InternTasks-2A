package com.mobillium.interntasks2a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobillium.interntasks2a.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            textCity.text = intent.getStringExtra(Constants.CITY)
            image.setImageResource(intent.getIntExtra(Constants.IMAGE,Constants.DEFAULT_VALUE))
            textWeatherDegree.text = intent.getStringExtra(Constants.WEATHER_DEGREE)
            textWeather.text = intent.getStringExtra(Constants.WEATHER)
        }
    }
}