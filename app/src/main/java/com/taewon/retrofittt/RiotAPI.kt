package com.taewon.retrofittt

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RiotAPI {
    @GET("/lol/summoner/v4/summoners/by-name/{id}")
    fun requestSearchAccount(
            @Path("id") id: String,
            @Query("api_key") api_key: String
    ): Call<Summoner>
    @GET("http://ddragon.leagueoflegends.com/cdn/10.23.1/img/item/{imageId}.png")
    fun requestSearchItem(
            @Path("imageId") id: String
    ): Call<ResponseBody>
}