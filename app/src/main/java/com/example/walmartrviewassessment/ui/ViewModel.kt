package com.example.walmartrviewassessment.ui

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

    val isLoading = MutableLiveData<Boolean>()

    init {
        fetchCountries()
    }

    private fun fetchCountries() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                val response = RetrofitInstance.api.getCountries()
                _countries.value = response
            } catch (e: Exception) {
                _error.value = e.localizedMessage
            } finally {
                isLoading.value = false
            }
        }
    }
}
