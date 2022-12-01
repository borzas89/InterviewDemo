package com.example.interviewdemo.network

import io.reactivex.Single
import retrofit2.http.GET

interface RestCountriesApi {

    @GET("v2/region/europe/")
    fun getEuropeanCountries(): Single<List<Country>>
}