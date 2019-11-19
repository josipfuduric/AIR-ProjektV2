package com.example.pop_sajamv2.Common

import com.example.pop_sajamv2.Remote.IMyAPI
import com.example.pop_sajamv2.Remote.RetrofitClient

object Common {
    val BASE_URL = "https://cortex.foi.hr/pop/"

    val api:IMyAPI
        get() = RetrofitClient.getClient(BASE_URL).create(IMyAPI::class.java)

}