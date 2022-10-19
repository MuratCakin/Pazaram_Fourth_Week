package com.muratcakin.weatherapp

import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.location.LocationManagerCompat.getCurrentLocation
import androidx.core.location.LocationManagerCompat.isLocationEnabled
import androidx.navigation.fragment.NavHostFragment
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.muratcakin.weatherapp.databinding.ActivityMainBinding
import com.muratcakin.weatherapp.databinding.FragmentWeatherBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var tvLatitude: TextView
    private lateinit var tvLongitude: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupNavController()

        //fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        //tvLatitude = binding.tvLatitude
       // tvLongitude = binding.tvLongitude
        //getCurrentLocation()
    }


    private fun setupNavController() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    }
/*
    private fun getCurrentLocation() {
        if(checkPermission()) {
            if(isLocationEnabled()) {

            } else {

            }
        } else {

        }


    }*/
}