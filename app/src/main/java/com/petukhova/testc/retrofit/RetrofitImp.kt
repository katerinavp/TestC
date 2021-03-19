package com.petukhova.testc.retrofit


import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitImp {

  fun getRequest(): Api {
    // создание Retrofit экземпляра
    val retrofit = Retrofit.Builder()
                .baseUrl("https://www.cbr-xml-daily.ru/")
                .addConverterFactory(GsonConverterFactory.create()) //конвертация объектовв json
                .build()
      Log.i("Auth go", "da")
        return retrofit.create(Api::class.java)
    }

}