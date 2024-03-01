package com.marisma.juegos.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.marisma.juegos.Juego1Fragment
import com.marisma.juegos.Juego2Fragment

class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int=2
    override fun createFragment(position: Int): Fragment {
        return when (position){

            0 -> Juego1Fragment()
            1 -> Juego2Fragment()

            else -> throw IllegalArgumentException("Posicion invalida: $position")

        }
    }
}