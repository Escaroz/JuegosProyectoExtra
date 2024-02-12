package com.marisma.juegos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.marisma.juegos.adapter.JuegoAdapter
import com.marisma.juegos.databinding.ActivityMainBinding
import com.marisma.juegos.databinding.ItemJuegoBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
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
