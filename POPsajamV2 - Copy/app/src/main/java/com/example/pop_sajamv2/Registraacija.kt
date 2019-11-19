package com.example.pop_sajamv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pop_sajamv2.Common.Common
import com.example.pop_sajamv2.Model.Api
import com.example.pop_sajamv2.Remote.IMyAPI
import kotlinx.android.synthetic.main.activity_registraacija.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Registraacija : AppCompatActivity() {

    internal lateinit var mService: IMyAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registraacija)

        mService = Common.api

        registracijaButton.setOnClickListener { createNewUser(KorisnickoIme.text.toString(), Lozinka.text.toString(), email.text.toString(), ime.text.toString(), prezime.text.toString(), tipKorisnika.text.toString()) }
    }

    private fun createNewUser(KorisnickoIme: String, Lozinka: String, email: String, ime: String, prezime: String, tipKorisnika: String) {
        mService.registerUser(KorisnickoIme,Lozinka,ime, prezime, email, tipKorisnika).enqueue(object:Callback<Api>{
            override fun onFailure(call: Call<Api>, t: Throwable) {
                Toast.makeText(this@Registraacija,t!!.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Api>, response: Response<Api>) {
                if(response!!.body()!!.error)
                    Toast.makeText(this@Registraacija,response!!.body()!!.error_msg,Toast.LENGTH_SHORT).show()
                else{
                    Toast.makeText(this@Registraacija,"Uspjesna registracija"+response.body()!!.uid,Toast.LENGTH_SHORT).show()
                    finish()
                }

            }

        })

    }
}
