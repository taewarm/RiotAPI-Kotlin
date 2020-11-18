package com.taewon.retrofittt

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RiotAPI {
    @GET("/lol/summoner/v4/summoners/by-name/{id}")
    fun requestSearchRiot(
            @Path("id") id: String,
            @Query("api_key") api_key: String
    ): Call<Summoner>
}