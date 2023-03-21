package com.example.pain_and_gain_app

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pain_and_gain_app.databinding.ActivityMainBinding
import com.example.pain_and_gain_app.main.add.ChadAddFragment
import com.example.pain_and_gain_app.main.list.ListFragment
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var topAppBar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val chadFrag = ChadAddFragment()
        switchFragment(chadFrag)

        topAppBar = binding.topAppbar

        topAppBar.setNavigationOnClickListener {
            Toast.makeText(this, "Navigation icon clicked", Toast.LENGTH_SHORT).show()
        }

        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search -> {
                    Toast.makeText(this, "Search action clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.more -> {
                    Toast.makeText(this, "More action clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

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