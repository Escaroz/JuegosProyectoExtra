package com.marisma.juegos

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.marisma.juegos.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.marisma.juegos.adapter.DetailActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

val Context.dataStore by preferencesDataStore(name = "USER_PREFERENCES_NAME")
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Datastore

        val btnSave = findViewById<Button>(R.id.btnSave)
        val etName = findViewById<EditText>(R.id.etName)
        val cbVIP = findViewById<CheckBox>(R.id.cbVIP)

        btnSave.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                saveValues(etName.text.toString(), cbVIP.isChecked)
            }
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            startActivity(intent) // Agregar esta línea para iniciar DetailActivity
        }


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
    private suspend fun saveValues(name: String, checked: Boolean){
        dataStore.edit { preferences ->
            preferences[stringPreferencesKey("name")] = name
            preferences[booleanPreferencesKey("vip")] = checked
        }
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