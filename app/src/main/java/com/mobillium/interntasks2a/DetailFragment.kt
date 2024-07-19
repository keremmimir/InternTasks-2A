package com.mobillium.interntasks2a

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobillium.interntasks2a.databinding.FragmentDetailBinding
import com.mobillium.interntasks2a.databinding.FragmentListBinding


class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { bundle ->
            binding.textCity.text = bundle.getString("city")
            binding.textWeatherDegree.text = bundle.getString("weather_degree")
            binding.textWeather.text = bundle.getString("weather")
            val imageResId = bundle.getInt("image", 0)
            if (imageResId != 0) {
                binding.image.setImageResource(imageResId)
            }
        }
    }
}