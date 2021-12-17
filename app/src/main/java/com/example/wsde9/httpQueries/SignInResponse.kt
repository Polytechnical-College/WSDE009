package com.example.wsde9.httpQueries

import com.google.gson.annotations.SerializedName

data class SignInResponse(
    @SerializedName("token")
    val token:Int,
    @SerializedName("notice")
    val notice:String
)
