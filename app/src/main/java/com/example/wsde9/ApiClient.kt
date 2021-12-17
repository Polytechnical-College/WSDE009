package com.example.wsde9

import com.example.wsde9.httpQueries.Api
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class ApiClient {

    private lateinit var apiService: Api

    fun getApiService():Api{
        val url: String = "http://cars.areas.su"

        if(!::apiService.isInitialized){

            val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            apiService = retrofit.create(Api::class.java)
        }

        return apiService
    }
}