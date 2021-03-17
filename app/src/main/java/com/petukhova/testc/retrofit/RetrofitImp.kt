package com.petukhova.testc.retrofit


import android.util.Log
import com.petukhova.testc.Api
import com.petukhova.testc.model.ModelCurrency
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitImp {

  fun getRequest(): Api {
    // Ленивое создание Retrofit экземпляра
    val retrofit = Retrofit.Builder()
                .baseUrl("https://www.cbr-xml-daily.ru/")
                .addConverterFactory(GsonConverterFactory.create()) //конвертация объектовв json
                .build()
      Log.i("Auth go", "da")
        return retrofit.create(Api::class.java)
    }
//    // Ленивое создание API
//    private val api: Api by lazy {
//        retrofit.create(
//                Api::class.java// передаем интерфейс , берем его класс
//        )
//    }

}