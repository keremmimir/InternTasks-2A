package com.mobillium.interntasks2a

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        binding.rv.adapter=adapter

        adapter.onClick = { model ->
            val action = NavigationListFragmentDirections.actionNavigationListFragmentToNavigationDetailFragment(model = model)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}