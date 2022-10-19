package com.muratcakin.weatherapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.muratcakin.weatherapp.data.api.ApiClient
import com.muratcakin.weatherapp.data.models.Model
import com.muratcakin.weatherapp.databinding.FragmentWeatherBinding
import com.muratcakin.weatherapp.ui.adapter.DaysAdapter
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.roundToInt

class WeatherFragment : Fragment() {

    // define viewbinding
    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWeatherBinding.inflate(inflater, container, false) // inflate binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getWeatherData()
    }

    // get api data
    private fun getWeatherData() {
        ApiClient
            .getApiService()
            .getWeatherData(40.2216568, 28.962078, "metric")
            .enqueue(object : Callback<Model> {
                override fun onResponse(call: Call<Model>, response: Response<Model>) {
                    Log.d("WeatherFragment", response.body().toString())

                    if (response.isSuccessful) {
                        val weather = response.body()
                        weather?.let { model ->
                            binding.rvDaysList.adapter = DaysAdapter().apply {
                                submitList(model.daily)
                            }
                            Picasso.get().load("https://openweathermap.org/img/wn/${model.current?.weather?.get(0)?.icon}@2x.png").into(binding.ivCurrentIcon)
                            binding.tvCurrentWeather.text = "${((model.current?.temp!! * 1.0).roundToInt() / 1.0).toInt().toString()}\u00B0"
                            Log.d("WeatherFragment", model.daily?.get(0)?.weather?.get(0)?.description.toString())
                        }
                    }
                }

                override fun onFailure(call: Call<Model>, t: Throwable) {
                    Log.d("deneme1", t.message.toString())
                }
            })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}