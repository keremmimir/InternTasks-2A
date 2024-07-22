package com.mobillium.interntasks2a

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobillium.interntasks2a.databinding.ListRowBinding

class ListAdapter(val data : ArrayList<Model>):RecyclerView.Adapter<ListAdapter.Holder>() {

    var onClick:((Model)-> Unit)? = null

    inner class Holder (val binding: ListRowBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(model: Model) {
            with(binding){
                rvCity.text = model.city
                rvWeather.text = model.weather
                rvDegreeRange.text = model.degree_range
                rvWeatherDegree.text = model.weather_degree
                rvImage.setImageResource(model.image)
            }

            itemView.setOnClickListener {
                onClick?.invoke(model)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.Holder {
        val binding = ListRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: ListAdapter.Holder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}