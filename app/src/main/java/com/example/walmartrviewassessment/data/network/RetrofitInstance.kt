package com.example.walmartrviewassessment.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object RetrofitInstance {
    val api: CountryApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/peymano-wmt/") // base part
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountryApi::class.java)
    }
}