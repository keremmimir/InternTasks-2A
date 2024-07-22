package com.mobillium.interntasks2a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobillium.interntasks2a.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val item = Repository().getWeatherItem()
        val adapter = ListAdapter(item)
        binding.rv.adapter=adapter

        adapter.onClick = { model->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra(Constants.CITY, model.city)
                putExtra(Constants.WEATHER_DEGREE, model.weather_degree)
                putExtra(Constants.WEATHER, model.weather)
                putExtra(Constants.IMAGE, model.image)
            }
            startActivity(intent)
        }
    }
}