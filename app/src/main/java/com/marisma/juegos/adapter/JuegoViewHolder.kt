package com.marisma.juegos.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marisma.juegos.Datos
import com.marisma.juegos.JuegoProvider
import com.marisma.juegos.databinding.ItemJuegoBinding

class JuegoViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val binding = ItemJuegoBinding.bind(view)

    fun render(juegoHolder: Datos, onClickListener: (Datos) -> Unit){
        binding.tvEquipoName.text = juegoHolder.juego
        binding.tvEquipoLiga.text = juegoHolder.fecha
        binding.tvEquipoEstadio.text = juegoHolder.genero
        Glide.with(binding.ivEquipo.context).load(juegoHolder.foto).into(binding.ivEquipo)
        itemView.setOnClickListener{onClickListener(juegoHolder)}

    }


}
