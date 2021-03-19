package com.petukhova.testc.retrofit

import android.util.Log
import com.petukhova.testc.R
import com.petukhova.testc.model.ModelResponse
import com.petukhova.testc.model.MyModelCurrency
import com.petukhova.testc.repository.CurrencyRepositoryImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import splitties.toast.toast

class RetrofitService {
    private val retrofitImpl: RetrofitImp = RetrofitImp()

    fun sendServerRequest() {
        retrofitImpl.getRequest().getCurrency().enqueue(object : Callback<ModelResponse> {

            override fun onResponse(
                call: Call<ModelResponse>,
                response: Response<ModelResponse>,
            ) {
                if (response.isSuccessful && response.body() != null)
                    makeData(response.body()!!)
                Log.i("body", "${response.body()}")
            }


            override fun onFailure(call: Call<ModelResponse>, t: Throwable) {
                toast(R.string.error)
                Log.i("error", "$t")

            }

        })
    }

    //получаем ответ от сервера и конвертируем полученные данные в currencyList = mutableListOf<MyModelCurrency>()
    private fun makeData(data: ModelResponse) {
        Log.i("makeData", "$data")
        val currencyList = mutableListOf<MyModelCurrency>()
        val currencuMap = data.valute
        for ((key, value) in currencuMap) {
            println("Key is $key, value is $value")
            val modelCurrency = MyModelCurrency(value.charCode, value.name, value.value)
            currencyList.add(modelCurrency)

        }

        CurrencyRepositoryImpl.saveListCurrency(currencyList)
        Log.i("передаем в репозиторий", "$currencyList")
    }


}