package com.example.walmartrviewassessment.data.network

import com.example.walmartrviewassessment.data.model.Country
import retrofit2.http.GET

interface CountryApi {
    @GET("32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json")
    suspend fun getCountries(): List<Country>
}