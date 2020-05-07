package com.enaz.baratostore

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.enaz.baratostore.add.AddFragment
import com.enaz.baratostore.common.manager.FirebaseAuthenticationManager
import com.enaz.baratostore.database.model.ProductItem
import com.enaz.baratostore.dialog.LoginOrRegisterDialog
import com.enaz.baratostore.home.HomeFragment
import com.enaz.baratostore.home.HomeViewModel
import com.enaz.baratostore.listener.CallbackListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() , HomeFragment.OnHomeFragmentFragmentListener,
    AddFragment.OnAddFragmentListener {

    private lateinit var navView: BottomNavigationView
    private lateinit var navController: NavController

    @Inject
    lateinit var firebaseAuthenticationManager: FirebaseAuthenticationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navView = findViewById(R.id.nav_view)

        navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_add,
                R.id.navigation_feed,
                R.id.navigation_cart,
                R.id.navigation_profile
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //TODO: add this account if login as admin.
//        navView.menu.findItem(R.id.navigation_add).isVisible = true

        showDialog()
    }

    override fun onHomeProductItemClicked(productItem: ProductItem) {
        TODO("Not yet implemented")
    }

    override fun setSelectedAddMenu() {
        navView.menu.findItem(R.id.navigation_home).onNavDestinationSelected(navController)
    }

    private fun showDialog() {
        val dialogFragment = LoginOrRegisterDialog(firebaseAuthenticationManager)
        dialogFragment.show(supportFragmentManager, "login")
    }
}
