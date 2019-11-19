package com.example.pop_sajamv2.Remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Url
import com.google.gson.GsonBuilder
import com.google.gson.Gson



object RetrofitClient{
    private var retrofit:Retrofit?=null
    var gson = GsonBuilder()
        .setLenient()
        .create()
    fun getClient(baseUrl:String):Retrofit{
        if(retrofit == null){
            retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create(gson)).build()
        }
        return retrofit!!
    }




}