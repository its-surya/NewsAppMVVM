package com.example.newsappassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.newsappassignment.adapters.NewsAdapter
import com.example.newsappassignment.api.NewsAPI
import com.example.newsappassignment.api.RetroFitHelper
import com.example.newsappassignment.databinding.ActivityMainBinding
import com.example.newsappassignment.fragments.HomeFragment
import com.example.newsappassignment.fragments.ProfileFragment
import com.example.newsappassignment.fragments.SaveFragment
import com.example.newsappassignment.repository.NewsRepository
import com.example.newsappassignment.viewmodels.MainViewModel
import com.example.newsappassignment.viewmodels.MainViewModelFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        //initially HomeFragment must be displayed
        if(savedInstanceState==null)
            replaceFragment(HomeFragment())
        binding.bottomNavBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.save -> {
                    replaceFragment(ProfileFragment())
                    true
                }

                R.id.profile -> {
                    replaceFragment(SaveFragment())
                    true
                }

                else -> {
                    false
                }
            }


        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout_home, fragment)
        fragmentTransaction.commit()
    }

}