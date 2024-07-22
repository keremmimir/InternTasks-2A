package com.mobillium.interntasks2a

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobillium.interntasks2a.databinding.FragmentDetailBinding
import com.mobillium.interntasks2a.databinding.FragmentNavigationDetailBinding
import com.mobillium.interntasks2a.databinding.FragmentNavigationListBinding

/
class NavigationDetailFragment : Fragment() {

    private var _binding: FragmentNavigationDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNavigationDetailBinding.inflate(inflater, container, false)
        return binding.root
    }


}