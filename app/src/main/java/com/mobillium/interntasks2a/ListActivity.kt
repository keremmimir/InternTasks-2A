package com.mobillium.interntasks2a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobillium.interntasks2a.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val item = Repository().getWeatherItem()
        val adapter = ListAdapter(item)
        binding.rv.adapter=adapter

        adapter.onclick={

            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("city", it.city)
                putExtra("weather_degree", it.weather_degree)
                putExtra("weather", it.weather)
                putExtra("image", it.icon)
            }
            startActivity(intent)
        }


    }
}