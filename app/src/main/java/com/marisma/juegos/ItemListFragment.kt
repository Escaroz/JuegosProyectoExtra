package com.marisma.juegos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.marisma.juegos.adapter.JuegoAdapter
import com.marisma.juegos.databinding.FragmentItemListBinding

class ItemListFragment : Fragment() {

    private var _binding: FragmentItemListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.item_list_title)

        iniciarRecyclerView()

        binding.btnPerfil.setOnClickListener {
            findNavController().navigate(R.id.action_itemListFragment_to_userInfoFragment)
        }

        binding.reciclerJuegos.adapter = JuegoAdapter(JuegoProvider.listaJuegosNintendo) { datos ->
            onItemSelected(datos)
        }
    }

    private fun iniciarRecyclerView() {
        val layoutManager = GridLayoutManager(requireContext(), 1)
        binding.reciclerJuegos.layoutManager = layoutManager
    }

    private fun onItemSelected(datos: Datos) {
        val bundle = Bundle().apply {
            putString("juegoNombre", datos.juego)
            putString("juegoGenero", datos.genero)
            putString("juegoEstudio", datos.fecha)
            putString("juegoFoto", datos.foto)
        }
        findNavController().navigate(R.id.action_itemListFragment_to_detailItemFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
