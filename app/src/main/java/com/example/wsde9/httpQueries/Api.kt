package com.example.wsde9.httpQueries

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {

    @POST("signup")
    fun signup(@Body request: SignUpRequest): Call<Void>

    @POST("login")
    fun signin(@Body request: SignInRequest): Call<SignInResponse>
}