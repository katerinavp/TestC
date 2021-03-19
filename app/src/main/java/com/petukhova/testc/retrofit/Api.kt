package com.petukhova.testc.retrofit

import com.petukhova.testc.model.ModelResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("daily_json.js")
    fun getCurrency(): Call<ModelResponse>

}