package com.example.walmartrviewassessment.ui.country

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.walmartrviewassessment.R
import com.example.walmartrviewassessment.data.model.Country

class CountryAdapter :
    ListAdapter<Country, CountryAdapter.CountryViewHolder>(CountryDiffCallback()) {

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
        val country = getItem(position)
        "${country.name}, ${country.region}".also { holder.nameRegion.text = it }
        holder.code.text = country.code
        holder.capital.text = country.capital
    }

    class CountryDiffCallback : DiffUtil.ItemCallback<Country>() {
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean =
            oldItem.code == newItem.code

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean =
            oldItem == newItem
    }
}