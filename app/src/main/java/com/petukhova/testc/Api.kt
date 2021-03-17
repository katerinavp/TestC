package com.petukhova.testc

import com.petukhova.testc.model.ModelCurrency
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("daily_json.js")
    fun getCurrency(): Call<List<ModelCurrency>>

//    fun getPicture(@Query("api_key") apiKey: String): Call<Data>
//}
}