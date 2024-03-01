package com.marisma.juegos.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.marisma.juegos.R
import com.marisma.juegos.databinding.FragmentLoginBinding
import com.marisma.juegos.databinding.FragmentMainBinding


class LoginFragment : Fragment() {
    private var _binding : FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val root: View = binding.root


        binding.buttonConectar.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_viewPagerFragment)

        }




        return root
    }




}