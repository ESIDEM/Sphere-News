package ng.com.techdepo.spherenews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*
import ng.com.techdepo.spherenews.R

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
       supportActionBar?.setDisplayShowTitleEnabled(false)
        val navController = Navigation.findNavController(this,
            R.id.fragment_navigation_host
        )

       NavigationUI.setupWithNavController(bottomNavigationView,navController)

    }



}
