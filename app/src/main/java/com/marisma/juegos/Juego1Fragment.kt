package com.marisma.juegos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marisma.juegos.databinding.FragmentJuego1Binding

class Juego1Fragment : Fragment() {


    private var _binding : FragmentJuego1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.fragment_about1, container, false)

        _binding = FragmentJuego1Binding.inflate(inflater, container, false)

        return binding.root
    }


}