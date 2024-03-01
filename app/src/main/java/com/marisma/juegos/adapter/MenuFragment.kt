package com.marisma.juegos.adapter
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.marisma.juegos.JuegoProvider
import com.marisma.juegos.R
import com.marisma.juegos.ReciclerViewFragment
import com.marisma.juegos.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        val root = binding.root
        val view = inflater.inflate(R.layout.fragment_menu, container, false)
        binding.buttonGame1.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_reciclerViewFragment)
        }

        // Obtener referencias a los botones
        val buttonGame1 = view.findViewById<Button>(R.id.buttonGame1)
        val buttonGame2 = view.findViewById<Button>(R.id.buttonGame2)
        val buttonGame3 = view.findViewById<Button>(R.id.buttonGame3)
        val buttonBackToLogin = view.findViewById<Button>(R.id.buttonBackToLogin)

        // Configurar OnClickListener para cada botón
        buttonGame1.setOnClickListener {

             //val fragment = JuegoProvider()
            // activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.reciclerJuegos, JuegoViewHolder )?.commit()
        }

        buttonGame2.setOnClickListener {
            // Abrir la aplicación de correo electrónico
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:")
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("correo@example.com"))
            startActivity(intent)
        }

        buttonGame3.setOnClickListener {

             activity?.supportFragmentManager?.popBackStack()
        }

        buttonBackToLogin.setOnClickListener {
            // Aquí puedes realizar la navegación al fragmento de LoginFragment
           // val loginFragment = LoginFragment()
            //activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.loginFragment, loginFragment)?.commit()
        }




        return root
    }
}
