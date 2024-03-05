package com.marisma.juegos.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.marisma.juegos.R
import com.marisma.juegos.databinding.FragmentDetailItemBinding

class DetailItemFragment : Fragment() {

    private var _binding: FragmentDetailItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val juegoNombre = arguments?.getString("juegoNombre")
        val juegoGenero = arguments?.getString("juegoGenero")
        val juegoEstudio = arguments?.getString("juegoEstudio")
        val juegoNota = arguments?.getInt("juegoNota", 0) // Valor predeterminado en caso de que no haya un valor
        val juegoFoto = arguments?.getString("juegoFoto")

        // Actualizar las vistas con los detalles del juego
        juegoNombre?.let {
            binding.textViewJuego.text = "Nombre: $it"
        }
        juegoGenero?.let {
            binding.textViewGenero.text = "Género: $it"
        }
        juegoEstudio?.let {
            binding.textViewEstudio.text = "Fecha: $it"
        }
        juegoNota?.let {
            binding.textViewNota.text = "Foto: $it"
        }

        juegoFoto?.let {
            // Cargar la foto utilizando Glide o Picasso
            Glide.with(this)
                .load(juegoFoto)
                .placeholder(R.drawable.zelda) // Opcional: establece una imagen de marcador de posición mientras se carga la imagen
                .error(R.drawable.zelda) // Opcional: establece una imagen de error si la carga de la imagen falla
                .into(binding.ivJuego)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
