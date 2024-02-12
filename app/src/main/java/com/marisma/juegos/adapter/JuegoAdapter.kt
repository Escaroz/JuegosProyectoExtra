package com.marisma.juegos.adapter

import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marisma.juegos.Datos
import com.marisma.juegos.R

class JuegoAdapter(private val juegosLista:List<Datos>, private val onClickListener: (Datos) -> Unit) : RecyclerView.Adapter<JuegoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JuegoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return JuegoViewHolder(layoutInflater.inflate(R.layout.item_juego,parent,false))
    }

    override fun getItemCount(): Int = juegosLista.size

    override fun onBindViewHolder(holder: JuegoViewHolder, position: Int) {
        holder.render(juegosLista[position], onClickListener)

    }

}