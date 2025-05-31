package com.example.walmartrviewassessment.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.walmartrviewassessment.R
import com.example.walmartrviewassessment.ui.country.CountryAdapter
import com.example.walmartrviewassessment.ui.country.CountryViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CountryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val emptyView = findViewById<TextView>(R.id.tvEmpty)
        val btnRetry = findViewById<Button>(R.id.btnRetry)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(this)[CountryViewModel::class.java]

        val adapter = CountryAdapter()
        recyclerView.adapter = adapter

        viewModel.countries.observe(this) { countries ->
            if (countries.isEmpty()) {
                recyclerView.visibility = View.GONE
                emptyView.visibility = View.VISIBLE
            } else {
                recyclerView.visibility = View.VISIBLE
                emptyView.visibility = View.GONE
                adapter.submitList(countries)
            }
        }

        viewModel.error.observe(this) { error ->
            if (error != null) {
                Toast.makeText(this, getString(R.string.load_error, error), Toast.LENGTH_LONG)
                    .show()
                btnRetry.visibility = View.VISIBLE
            } else {
                btnRetry.visibility = View.GONE
            }
        }

        viewModel.isLoading.observe(this) { isLoading ->
            progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        btnRetry.setOnClickListener {
            viewModel.fetchCountries()
        }
    }
}