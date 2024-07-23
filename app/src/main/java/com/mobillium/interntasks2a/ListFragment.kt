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

        adapter.onClick = { model ->
            val detailFragment = DetailFragment()
            val bundle = Bundle().apply {
                putString(Constants.CITY, model.city)
                putString(Constants.WEATHER_DEGREE, model.weather_degree)
                putString(Constants.WEATHER, model.weather)
                putInt(Constants.IMAGE, model.image)
            }
            detailFragment.arguments = bundle

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, detailFragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}