package com.gurpreet.singh.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private var controller: NavController? = null
    private var listener: NavController.OnDestinationChangedListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        controller = findNavController(R.id.fragment)

        bottomNavigationView.setupWithNavController(controller!!)

        listener =
            NavController.OnDestinationChangedListener { controller, destination, arguments ->

                if (destination.id == R.id.iconSetsFragment || destination.id == R.id.iconsFragment) {
                    bottomNavigationView.visibility = View.VISIBLE
                    supportActionBar!!.title = "Home"
                } else {
                    bottomNavigationView.visibility = View.INVISIBLE
                    setTitle("New Title")
                    supportActionBar!!.title = ""
                }
            }

        controller?.addOnDestinationChangedListener(listener!!)
        NavigationUI.setupActionBarWithNavController(this, controller!!)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.fragment)

        return navController.navigateUp()
    }
}