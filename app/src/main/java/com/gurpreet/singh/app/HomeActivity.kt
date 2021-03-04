package com.gurpreet.singh.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private var controller: NavController? = null
    private  var listener: NavController.OnDestinationChangedListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        controller = findNavController(R.id.fragment)

        bottomNavigationView.setupWithNavController(controller!!)

        listener = NavController.OnDestinationChangedListener { controller, destination, arguments ->
                if (destination.id == R.id.iconSetsFragment || destination.id == R.id.iconsFragment) {
                    bottomNavigationView.visibility = View.VISIBLE
                } else {
                    bottomNavigationView.visibility = View.INVISIBLE
                }
            }

        controller?.addOnDestinationChangedListener(listener!!)

    }
}