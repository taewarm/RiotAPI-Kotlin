package com.taewon.retrofittt

import android.app.Activity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : Activity() {
    val API_KEY: String = "RGAPI-9ec7c329-788a-45c8-89a0-4defc9e54b36"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val response = SearchRetrofit.getService().requestSearchRiot("태원이심신미약",API_KEY)
        response.enqueue(object : Callback<Summoner>{
            override fun onResponse(call: Call<Summoner>, response: Response<Summoner>) {
                response?.let {
                    var asd: Summoner? = it.body()

                    Log.i("여기",asd.toString())
                }
            }

            override fun onFailure(call: Call<Summoner>, t: Throwable) {
                Log.i("여기",t.message)
            }
        })

    }
}
