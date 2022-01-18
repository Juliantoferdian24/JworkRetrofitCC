package com.ferdian.jworkretrofitcc

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: BonusApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.1.116:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BonusApi::class.java)
    }
}