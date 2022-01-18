package com.ferdian.jworkretrofitcc

import retrofit2.Response
import retrofit2.http.GET

interface BonusApi {

    @GET("/bonus")
    suspend fun getBonus(): Response<List<Bonus>>
}