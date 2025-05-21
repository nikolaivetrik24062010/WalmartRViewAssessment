package com.example.walmartrviewassessment.ui

import com.example.walmartrviewassessment.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.walmartrviewassessment.data.model.Country

class CountryAdapter(private val countries: List<Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameRegion: TextView = view.findViewById(R.id.tvNameRegion)
        val code: TextView = view.findViewById(R.id.tvCode)
        val capital: TextView = view.findViewById(R.id.tvCapital)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countries[position]
        holder.nameRegion.text = "${country.name}, ${country.region}"
        holder.code.text = country.code
        holder.capital.text = country.capital
    }

    override fun getItemCount() = countries.size
}