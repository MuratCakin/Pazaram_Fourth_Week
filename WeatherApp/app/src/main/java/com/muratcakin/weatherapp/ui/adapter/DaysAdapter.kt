package com.muratcakin.weatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.muratcakin.weatherapp.data.models.Daily
import com.muratcakin.weatherapp.databinding.ItemDayBinding
import com.squareup.picasso.Picasso
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

// create adapter for recyclerview, define high-order func. for pass data to detail fragment with arguments
class DaysAdapter() : ListAdapter<Daily, DaysAdapter.DaysViewHolder>(DaysDiffUtil()) {

    class DaysViewHolder(private val itemDayBinding: ItemDayBinding): RecyclerView.ViewHolder(itemDayBinding.root) {

        fun bind(daily: Daily) {
            val date = daily.dt?.toLong()
            val icon = daily.weather?.get(0)?.icon
            val maxTemp = ((daily.temp?.max!! * 1.0).roundToInt() / 1.0).toInt().toString()
            val minTemp = ((daily.temp.min!! * 1.0).roundToInt() / 1.0).toInt().toString()

            // dt value convert to date
            fun newDate(dt : Long) {
                val timeStamp = date?.let { Timestamp(dt) }
                val dateName = Date(timeStamp!!.time * 1000)
                itemDayBinding.tvDay.text = SimpleDateFormat("EEEE", Locale("tr")).format(dateName)
            }

            itemDayBinding.apply {
                date?.let { newDate(it) }
                tvMaxTemp.text = "$maxTemp\u00B0"  // u00B0 is degree symbol
                tvMinTemp.text = "$minTemp\u00B0"
                Picasso.get().load("https://openweathermap.org/img/wn/${icon}@2x.png").into(ivIcon)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DaysViewHolder {
        val itemDayBinding = ItemDayBinding.inflate(LayoutInflater.from(parent.context))
        return DaysViewHolder(itemDayBinding)
    }

    override fun onBindViewHolder(holder: DaysViewHolder, position: Int) {
        holder.bind(getItem(position))
    }




    class DaysDiffUtil: DiffUtil.ItemCallback<Daily>() {
        override fun areItemsTheSame(oldItem: Daily, newItem: Daily): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Daily, newItem: Daily): Boolean {
            return oldItem == newItem
        }

    }
}