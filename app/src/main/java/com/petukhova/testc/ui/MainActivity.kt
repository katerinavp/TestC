package com.petukhova.testc.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.petukhova.testc.adapter.AdapterCurrency
import com.petukhova.testc.databinding.ActivityMainBinding
import com.petukhova.testc.repository.CurrencyImpl
import com.petukhova.testc.retrofit.RetrofitImp
import com.petukhova.testc.server.Server
import com.petukhova.testc.viewmodel.CurrencyViewModel
import kotlinx.coroutines.launch
import splitties.activities.start


class MainActivity : AppCompatActivity() {
    private val retrofitImpl: RetrofitImp = RetrofitImp()
    lateinit var adapter: AdapterCurrency
    private var server: Server = Server()
    var currencyRepository = CurrencyImpl()

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(LayoutInflater.from(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = AdapterCurrency()
        binding.recyclerView.adapter = adapter

//        binding.progressBar.isVisible = true
//        binding.progressBar.isInvisible = true
        //подписываемся на ViewModel

//        adapter.submitList(currencyViewModel.getData())
        // currencyViewModel.getData().observe(this,  adapter::submitList)


        // При нажатии на кнопки загрузить данные и отобразить
        lifecycleScope.launch {
            binding.btnUpdate.setOnClickListener { server.sendServerRequest() }
        }
        binding.btnConvert.setOnClickListener { goConvertActivity() }
        //подписываем адаптер на изменения списка
//        adapter.submitList(currencyViewModel.getData())

        //подписываем адаптер на изменения списка
        //currencyViewModel.getData().observe(this, adapter::submitList)
        val currencyViewModel: CurrencyViewModel = ViewModelProviders.of(this).get(CurrencyViewModel::class.java)
        //adapter.submitList(currencyViewModel.getData())
        currencyViewModel.getData().observe(this, adapter::submitList)
        // Log.i("viewmodel вернули main", "${currencyViewModel.getData()}")
        // binding.progressBar.isVisible = true
    }

//    fun sendServerRequest() {
//        binding.progressBar.isVisible = true
//        retrofitImpl.getRequest().getCurrency().enqueue(object : Callback<ModelResponse> {
//            override fun onResponse(
//                call: Call<ModelResponse>,
//                response: Response<ModelResponse>
//            ) {
//                if (response.isSuccessful && response.body() != null) {
//
//                    makeData(response.body()!!)
//                    println("Тело запроса" + "${response.body()}")
//                    Log.i("Auth go", "${response.body()}")
//                } else {
//                    Log.i("Ош", "${response.body()}")
//                    //makeData(null, Throwable("Ответ от сервера пустой"))
//                }
//                binding.progressBar.isInvisible = true
//
//            }
//
//            override fun onFailure(call: Call<ModelResponse>, t: Throwable) {
//                toast("Ошибка")
//                Log.i("Ошибка", "$t")
//
//            }
//
//        })
//
//    }
//
//    fun makeData(data: ModelResponse) {
//        val currencyList = mutableListOf<MyModelCurrency>()
//        val currentDate = data.date
//        val currencuMap = data.valute
//        for ((key, value) in currencuMap) {
//            println("Key is $key, value is $value")
//            val modelCurrency = MyModelCurrency(value.charCode, value.name, value.value, currentDate)
//            //val currencyList = mutableListOf<ModelCurrency>()
//            currencyList.add(modelCurrency)
//            println(" наша модель  $modelCurrency ")
//
//        }
//
//        adapter.submitList(currencyList)
//
//    }

    fun goConvertActivity() {
        start<ConvertActivity>()
    }

    override fun onStart() {
        super.onStart()

    }
}








