package com.mobillium.interntasks2a

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobillium.interntasks2a.databinding.FragmentListBinding


class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item = Repository().getWeatherItem()
        val adapter = ListAdapter(item)
        binding.rv.adapter=adapter

        adapter.onclick={
            val secondFragment = DetailFragment()

            val bundle = Bundle()
            bundle.putString("city", it.city)
            bundle.putString("weather_degree", it.weather_degree)
            bundle.putString("weather", it.weather)
            bundle.putInt("image", it.icon)
            secondFragment.arguments = bundle

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, secondFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}