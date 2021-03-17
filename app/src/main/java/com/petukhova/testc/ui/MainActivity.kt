package com.petukhova.testc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.petukhova.testc.adapter.AdapterCurrency
import com.petukhova.testc.databinding.ActivityMainBinding
import com.petukhova.testc.model.ModelCurrency
import com.petukhova.testc.retrofit.RetrofitImp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import splitties.toast.toast


class MainActivity : AppCompatActivity() {
    private val retrofitImpl: RetrofitImp = RetrofitImp()
    lateinit var adapter: AdapterCurrency

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(LayoutInflater.from(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        sendServerRequest()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = AdapterCurrency()
        binding.recyclerView.adapter = adapter
        // binding.progressBar.isVisible = true
    }

    private fun sendServerRequest() {
        binding.progressBar.isVisible = true
//       val retr: Call<List<ModelCurrency>> = retrofitImpl.getRequest().getCurrency()
//        retr.enqueue(Callback<List<ModelCurrency>>(){
        retrofitImpl.getRequest().getCurrency().enqueue(object : Callback<List<ModelCurrency>> {
            override fun onResponse(
                call: Call<List<ModelCurrency>>,
                response: Response<List<ModelCurrency>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    //makeData(response.body())
                    println("Тело запроса" + "${response.body()}")
                    Log.i("Auth go", "${response.body()}")
                } else {
                    Log.i("Ош", "${response.body()}")
                    //makeData(null, Throwable("Ответ от сервера пустой"))
                }
                binding.progressBar.isInvisible = true

            }

            override fun onFailure(call: Call<List<ModelCurrency>>, t: Throwable) {
                toast("Ошибка")
                Log.i("Ошибка", "$t")

            }

        })
    }


    private fun makeData(data: List<ModelCurrency>?) {
        if (data == null) {
            //Ошибка
            //Toast.makeText(this, error?.message, Toast.LENGTH_SHORT).show()
        } else {
//            val ticker = data.CharCode
//            val nameCurrency = data.Name
//            val currentDate
//            val value=data.Value
//            Log.i("данные вывод" + data)
//            var list = mutableListOf<ModelCurrency>()
//            var modelCurrency:ModelCurrency = ModelCurrency(ticker, nameCurrency, value)
//            list.add(modelCurrency )
            adapter.submitList(data)

//            if (url.isNullOrEmpty()) {
//                //"Ссылка на фото пустая")
//                Toast.makeText(this, "@string/empty_message", Toast.LENGTH_SHORT).show()
//            } else if (url.contains("www.youtube.com")) {
//                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
//            } else {
//                binding.image.load(url)
//            }
//            val explanation = data.explanation
//            if (explanation.isNullOrEmpty()) {
//                //"Описание пустое"
//                Toast.makeText(this, "Описание пустое", Toast.LENGTH_SHORT).show()
//            } else {
//                binding.txtExplanation.text = explanation
//            }
        }
    }

}