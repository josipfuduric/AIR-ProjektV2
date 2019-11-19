package com.example.pop_sajamv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pop_sajamv2.Common.Common
import com.example.pop_sajamv2.Model.Api
import com.example.pop_sajamv2.Remote.IMyAPI
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.KorisnickoIme
import kotlinx.android.synthetic.main.activity_main.Lozinka
import kotlinx.android.synthetic.main.activity_main.registracijaButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    internal lateinit var mService:IMyAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.api

        registracijaButton.setOnClickListener{startActivity(Intent(this@MainActivity,Registraacija::class.java))}
        loginButton.setOnClickListener{authenticateUser(KorisnickoIme.text.toString(),Lozinka.text.toString())}
    }

    private fun authenticateUser(KorisnickoIme: String, Lozinka: String) {
        mService.loginUser(KorisnickoIme,Lozinka ).enqueue(object: Callback<Api>{
            override fun onFailure(call: Call<Api>, t: Throwable) {
                Toast.makeText(this@MainActivity,t!!.message,Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Api>, response: Response<Api>) {
                if(response!!.body()!!.error)
                    Toast.makeText(this@MainActivity,response!!.body()!!.error_msg,Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this@MainActivity,"Uspjesna prijava",Toast.LENGTH_SHORT).show()
            }
        })

    }
}
