package com.petukhova.testc.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.petukhova.testc.model.MyModelCurrency
import com.petukhova.testc.repository.CurrencyRepositoryImpl


import com.petukhova.testc.retrofit.RetrofitService
import kotlinx.coroutines.delay


class CurrencyViewModel : ViewModel() {

    private var listLiveData: MutableLiveData<List<MyModelCurrency>> = MutableLiveData()
    private var service: RetrofitService = RetrofitService()

    suspend fun init() {
        updateListCurrency()
    }

    fun getData(): MutableLiveData<List<MyModelCurrency>> = listLiveData

    //загрузка данных из сервера
    suspend fun updateListCurrency() {
        service.sendServerRequest()
        Log.i("сервис", "запущен")

        savelistLiveData()

    }

    //сохранение данных в LiveData
    suspend fun savelistLiveData() {
        delay(1000)
        listLiveData?.postValue(CurrencyRepositoryImpl.getAllCurrency())
        Log.i("loadData", "${listLiveData}")


    }

}



