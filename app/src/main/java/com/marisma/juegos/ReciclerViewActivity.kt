package com.marisma.juegos

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.marisma.juegos.adapter.JuegoAdapter
import com.marisma.juegos.databinding.FragmentReciclerViewBinding

class ReciclerViewActivity : AppCompatActivity() {
    private lateinit var binding: FragmentReciclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_recicler_view)
        binding = FragmentReciclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        iniciarRecyclerView()
    }
    fun iniciarRecyclerView(){
        val manager = GridLayoutManager(this,1)
        binding.reciclerJuegos.layoutManager = manager
        binding.reciclerJuegos.adapter = JuegoAdapter(JuegoProvider.listaJuegosNintendo){
                datos ->  onItemSelected(
            datos
        )
        }


    }
    private fun onItemSelected(datos:Datos){
        Toast.makeText(
            this,
            datos.juego,
            Toast.LENGTH_SHORT
        ).show()
    }

}