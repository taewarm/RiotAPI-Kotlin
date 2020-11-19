package com.taewon.retrofittt

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : Activity() {
    val API_KEY: String = "RGAPI-a35269d5-4f37-490c-b96e-9f8ad33428f2"
    var IconURL: String =""
    var AcName: String? =""
    var AcLevel: String? =""
    var AcIcon: String? =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var imageView: ImageView = findViewById(R.id.icon)

        val response = SearchRetrofit.getService().requestSearchAccount("태원이 심신미약",API_KEY)
        response.enqueue(object : Callback<Summoner>{
            override fun onResponse(call: Call<Summoner>, response: Response<Summoner>) {
                /*response?.let {
                    var asd: Summoner? = it.body()

                    Log.i("여기",asd.toString())
                }*/
                var asd: Summoner? = response.body()
                AcName = asd?.name
                AcLevel = asd?.summonerLevel
                AcIcon = asd?.profileIconId

                Log.i("여기",asd.toString())
                IconURL = "http://ddragon.leagueoflegends.com/cdn/10.23.1/img/profileicon/${AcIcon}.png"
                imageView.loadUrl(IconURL)
            }

            override fun onFailure(call: Call<Summoner>, t: Throwable) {
                Log.i("여기",t.message)
            }
        })

    }
    fun ImageView.loadUrl(url: String){
        Picasso.with(context).load(url).into(this)
    }
}
