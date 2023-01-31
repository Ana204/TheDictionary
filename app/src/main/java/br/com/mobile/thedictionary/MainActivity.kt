package br.com.mobile.thedictionary

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.mobile.thedictionary.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val appToBar = binding.includeToBar.appToBar
        val navigationViewSelect = binding.navigationView

        appToBar.setOnClickListener {
            binding.drawerLayout.open()
        }

        navigationViewSelect.setNavigationItemSelectedListener { menuItem ->
         menuItem.isChecked = true
            binding.drawerLayout.close()
            true
        }
    }
}