package com.mobillium.interntasks2a

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobillium.interntasks2a.databinding.ListRowBinding

class ListAdapter(val data : ArrayList<Model>):RecyclerView.Adapter<ListAdapter.Holder>() {

    var onclick:((Model)-> Unit)? = null

    class Holder (val binding: ListRowBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.Holder {
        val binding=ListRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: ListAdapter.Holder, position: Int) {
        holder.binding.rvCity.text=data[position].city
        holder.binding.rvWeather.text=data[position].weather
        holder.binding.rvDegreeRange.text=data[position].degree_range
        holder.binding.rvWeatherDegree.text=data[position].weather_degree
        holder.binding.rvImage.setImageResource(data[position].icon)

        holder.itemView.setOnClickListener{
            onclick?.invoke(data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}