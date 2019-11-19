package com.example.pop_sajamv2.Remote

import com.example.pop_sajamv2.Model.Api
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface IMyAPI {
    @FormUrlEncoded
    @POST("registracija.php")

    fun registerUser(@Field("KorisnickoIme") KorisnickoIme:String,@Field("Lozinka") Lozinka:String, @Field("Ime") Ime:String,@Field("Prezime") Prezime:String, @Field("Email") Email:String,@Field("TipKorisnika") TipKorisnika:String):Call<Api>

    @FormUrlEncoded
    @POST("login.php")

    fun loginUser(@Field("KorisnickoIme") KorisnickoIme:String,@Field("Lozinka") Lozinka:String):Call<Api>
}