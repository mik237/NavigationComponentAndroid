package com.abroliza.navigationcompexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(toolbar)

    }

    override fun onStart() {
        super.onStart()
        val navigationController = findNavController(R.id.nav_host)
        setupBottomNavigation(navigationController)
        setupSideNavigation(navigationController)
        setupActionBar(navigationController)
    }

    private fun setupActionBar(navigationController: NavController) {
        NavigationUI.setupActionBarWithNavController(this, navigationController, drawer_layout)
    }

    private fun setupSideNavigation(navigationController: NavController) {
        nav_view?.let {
            NavigationUI.setupWithNavController(it, navigationController)
        }
    }

    private fun setupBottomNavigation(navigationController: NavController){
        bottom_nav?.let {
            NavigationUI.setupWithNavController(it, navigationController)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(Navigation.findNavController(this, R.id.nav_host), drawer_layout)
    }
}