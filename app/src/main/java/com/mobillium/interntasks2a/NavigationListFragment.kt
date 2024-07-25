package com.mobillium.interntasks2a

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.mobillium.interntasks2a.databinding.FragmentDetailBinding
import com.mobillium.interntasks2a.databinding.FragmentNavigationListBinding


class NavigationListFragment : Fragment() {

    private var _binding: FragmentNavigationListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNavigationListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item = Repository().getWeatherItem()
        val adapter = ListAdapter(item)

        binding.recyclerView.adapter = adapter

        adapter.onClick = { model ->
            val action =
                NavigationListFragmentDirections.actionNavigationListFragmentToNavigationDetailFragment(
                    model = model
                )
            findNavController().navigate(action)
        }

        setFragmentResultListener(Constants.RESTFUL_API) { requestKey, bundle ->
            val id = bundle.getInt(Constants.ID, -1)
            val updatedDegree = bundle.getInt(Constants.UPDATE_WEATHER_DEGREE, -1)

            if (id != -1 && updatedDegree != -1) {
                val updatedModel = item.find { model->
                    model.id == id
                }
                updatedModel?.let { model ->
                    model.weatherDegree = updatedDegree.toString()
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}