package com.petukhova.testc.server

import android.util.Log
import com.petukhova.testc.model.ModelResponse
import com.petukhova.testc.model.MyModelCurrency
import com.petukhova.testc.repository.CurrencyImpl
import com.petukhova.testc.repository.CurrencyRepository
import com.petukhova.testc.retrofit.RetrofitImp
import com.petukhova.testc.viewmodel.CurrencyViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import splitties.toast.toast

class Server {
    private val retrofitImpl: RetrofitImp = RetrofitImp()
    val currencyRepository: CurrencyRepository = CurrencyImpl()

    // lateinit var adapter: AdapterCurrency
    private val currencyViewModel = CurrencyViewModel()

 fun sendServerRequest() {

        retrofitImpl.getRequest().getCurrency().enqueue(object : Callback<ModelResponse> {
            override fun onResponse(
                call: Call<ModelResponse>,
                response: Response<ModelResponse>,
            ) {
                if (response.isSuccessful && response.body() != null) {
                    makeData(response.body()!!)
                    println("Тело запроса" + "${response.body()}")
                    Log.i("Auth go", "${response.body()}")
                } else {
                    Log.i("Ош", "${response.body()}")
                    //makeData(null, Throwable("Ответ от сервера пустой"))
                }
                //binding.progressBar.isInvisible = true

            }

            override fun onFailure(call: Call<ModelResponse>, t: Throwable) {
                toast("Ошибка")
                Log.i("Ошибка", "$t")

            }

        })

    }


    private fun makeData(data: ModelResponse) {
        Log.i("makeData", "$data")
        val currencyList = mutableListOf<MyModelCurrency>()
        val currentDate = data.date
        val currencuMap = data.valute
        for ((key, value) in currencuMap) {
            println("Key is $key, value is $value")
            val modelCurrency =
                MyModelCurrency(value.charCode, value.name, value.value, currentDate)
            //val currencyList = mutableListOf<ModelCurrency>()
            currencyList.add(modelCurrency)
            println(" наша модель  $modelCurrency ")
            //Log.i("передаем в репо", "$currencyList")


        }
       // currencyViewModel.saveData(currencyList)
        currencyRepository.saveListCurrency(currencyList)
        Log.i("передаем в репо", "$currencyList")
    }


}