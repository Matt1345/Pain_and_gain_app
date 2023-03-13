package com.example.pain_and_gain_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pain_and_gain_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val chadFrag = ChadAddFragment()
        switchFragment(chadFrag)

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            if (menuItem.itemId == binding.bottomNavigationView.selectedItemId) {
                return@setOnItemSelectedListener true
            }

            when (menuItem.itemId) {
                R.id.add -> {
                    switchFragment(ChadAddFragment())
                    true
                }
                R.id.chad_list -> {
                    switchFragment(ListFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun switchFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun changeBottomNavigationSelectedItem(position: Int) {
        binding.bottomNavigationView.menu.getItem(position).isChecked = true
    }
}