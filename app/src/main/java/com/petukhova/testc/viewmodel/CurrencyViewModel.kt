package com.petukhova.testc.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.petukhova.testc.model.MyModelCurrency
import com.petukhova.testc.repository.CurrencyRepositoryImpl


import com.petukhova.testc.retrofit.RetrofitService
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CurrencyViewModel : ViewModel() {
    //    private var listLiveData: MutableLiveData<List<MyModelCurrency>>
    private var listLiveData: MutableLiveData<List<MyModelCurrency>> = MutableLiveData()
//    private var listLiveData: MutableLiveData<List<MyModelCurrency>>? = null
    private var service: RetrofitService = RetrofitService()

    private var listViewModel = mutableListOf<MyModelCurrency>()

    suspend fun init() {
        updateListCurrency()
    }

        fun getData(): MutableLiveData<List<MyModelCurrency>> = listLiveData
//    suspend fun getData(): MutableLiveData<List<MyModelCurrency>>? {
//        if (listLiveData==null){
//            //listLiveData = MutableLiveData()
//            init()
//        }
//        return listLiveData
//    }

    suspend fun updateListCurrency() {
        service.sendServerRequest()
        Log.i("сервис", "запущен")

        savelistLiveData()

    }

    suspend fun savelistLiveData() {
        delay(1000)
        listLiveData.postValue(CurrencyRepositoryImpl.getAllCurrency())
        Log.i("loadData", "${listLiveData}")


    }

}



