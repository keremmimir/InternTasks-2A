package com.mobillium.interntasks2a

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mobillium.interntasks2a.databinding.FragmentDetailBinding
import com.mobillium.interntasks2a.databinding.FragmentNavigationDetailBinding
import com.mobillium.interntasks2a.databinding.FragmentNavigationListBinding

class NavigationDetailFragment : Fragment() {

    private var _binding: FragmentNavigationDetailBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<NavigationDetailFragmentArgs>()

    private var randomWeatherDegree: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNavigationDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            textCity.text = args.model.city
            textWeatherDegree.text = args.model.weather_degree
            textWeather.text = args.model.weather
            image.setImageResource(args.model.image)
        }

        binding.imageRefresh.setOnClickListener{
            randomWeatherDegree= Repository().randomWeatherDegree()
            binding.textWeatherDegree.text="$randomWeatherDegree°"
        }

        binding.dataUpdateButton.setOnClickListener {
            val resultBundle = Bundle().apply {
                putInt(Constants.ID, args.model.id)
                putInt(Constants.UPDATE_WEATHER_DEGREE, randomWeatherDegree ?: -1)
            }
            setFragmentResult(Constants.RESTFUL_API, resultBundle)
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}