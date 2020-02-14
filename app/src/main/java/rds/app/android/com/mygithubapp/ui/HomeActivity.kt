package rds.app.android.com.mygithubapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import rds.app.android.com.mygithubapp.R
import rds.app.android.com.mygithubapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        navController = findNavController(R.id.host_fragment)

        binding.bottomNavigation.setupWithNavController(navController)

    }
}
