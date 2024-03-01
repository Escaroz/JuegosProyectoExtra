package com.marisma.juegos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marisma.juegos.adapter.ViewPagerAdapter
import com.marisma.juegos.databinding.FragmentViewPagerBinding

class ViewPagerFragment : Fragment() {

    private var _binding: FragmentViewPagerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentViewPagerBinding.inflate(inflater,container,false)
        val adapter = ViewPagerAdapter(requireActivity())

        binding.pager.adapter=adapter


        return binding.root
    }


}