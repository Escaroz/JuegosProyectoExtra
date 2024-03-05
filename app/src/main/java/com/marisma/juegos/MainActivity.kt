package com.marisma.juegos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.marisma.juegos.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _, destination, _  ->
            if(destination.id == R.id.loginFragment) {
                binding.bottomNav.visibility = View.GONE
            } else {
                binding.bottomNav.visibility = View.VISIBLE
            }
        }
        setContentView( binding.root)

        binding.bottomNav.setupWithNavController(navController)

        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.navHostFragment)
        return navController.navigateUp()
    }
}

/**
 * private lateinit var binding: ActivityMainBinding
 *
 *
 *     private lateinit var drawerLayout: DrawerLayout
 *     private lateinit var navController: NavController
 *
 *
 *     /*override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
 *                               savedInstanceState: Bundle?): View ?{
 *                     return  binding.root
 *     }*/
 *
 *     override fun onCreate(savedInstanceState: Bundle?) {
 *
 *         super.onCreate(savedInstanceState)
 *         //setContentView(R.layout.activity_main)
 *         binding = ActivityMainBinding.inflate(layoutInflater)
 *         val view = binding.root
 *
 *         val toolbar: Toolbar = binding.toolbar
 *         setSupportActionBar(toolbar)
 *
 *         val navHostFragment = supportFragmentManager.findFragmentById(R.id.fcwMain) as NavHostFragment
 *         navController = navHostFragment.navController
 *
 *         //drawerLayout = findViewById(R.id.drawer_layout)
 *         //drawerLayout = binding.drawerNav
 *         drawerLayout = binding.drawerLayout
 *         //setupNavigationMenu()
 *
 *
 *         // Habilitar el botón de navegación hacia arriba (up button)
 *         NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
 *
 *
 *         /*_binding = ActivityMainBinding.inflate(layoutInflater)
 *         setContentView(binding.root)
 *
 *         setupNavegacion()*/
 *
 *         //Codigo del bottom menu
 *         binding.bottomNav.setupWithNavController(navController)
 *         //setupBottomMenu()
 *
 *         navController.addOnDestinationChangedListener { _, destination, _ ->
 *             if(destination.id == R.id.loginFragment) {
 *                 binding.toolbar.visibility = View.GONE
 *                 binding.bottomNav.visibility = View.GONE
 *             } else {
 *                 toolbar.visibility = View.VISIBLE
 *                 binding.bottomNav.visibility = View.VISIBLE
 *             }
 *         }
 *
 *
 *         setContentView(view)
 *
 *     }
 *
 *     override fun onSupportNavigateUp(): Boolean {
 *         return NavigationUI.navigateUp(navController, drawerLayout)
 *     } */