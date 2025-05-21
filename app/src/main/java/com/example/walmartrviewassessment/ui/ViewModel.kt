package com.example.walmartrviewassessment.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walmartrviewassessment.data.model.Country
import com.example.walmartrviewassessment.data.network.RetrofitInstance
import kotlinx.coroutines.launch

class CountryViewModel : ViewModel() {

    private val _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>> = _countries

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    init {
        fetchCountries()
    }

    private fun fetchCountries() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getCountries()
                _countries.value = response
                Log.d("CountryViewModel", "Fetched countries: ${response.size}")
            } catch (e: Exception) {
                _error.value = "Error: ${e.localizedMessage}"
                Log.e("CountryViewModel", "Error: ${e.message}")
            }
        }
    }
}