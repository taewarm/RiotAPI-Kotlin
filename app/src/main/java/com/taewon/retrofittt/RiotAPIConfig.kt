package com.taewon.retrofittt

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  SearchRetrofit {
    private val retrofit =
            Retrofit.Builder()
                    .baseUrl("https://kr.api.riotgames.com") // 도메인 주소
                    .addConverterFactory(GsonConverterFactory.create()) // GSON을 사요아기 위해 ConverterFactory에 GSON 지정
                    .build()
    fun getService(): RiotAPI = retrofit.create(RiotAPI::class.java)
}