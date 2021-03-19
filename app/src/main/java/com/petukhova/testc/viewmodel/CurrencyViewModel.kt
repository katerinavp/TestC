package com.petukhova.testc.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.petukhova.testc.model.MyModelCurrency
import com.petukhova.testc.repository.CurrencyImpl

class CurrencyViewModel : ViewModel() {
    private var data: MutableLiveData<List<MyModelCurrency>>? = null
    var currencyRepository = CurrencyImpl()

    private var listViewModel = mutableListOf<MyModelCurrency>()
    //    private lateinit var listViewModel: MutableList<MyModelCurrency>

//    fun getData(): List<MyModelCurrency> {
//        Log.i("viewmodel вернули", "$listViewModel")
//        return listViewModel
//
//    }

//    fun saveData(list: List<MyModelCurrency>) {
////        listViewModel = list.toMutableList()
////        listViewModel.addAll(list)
//        listViewModel.addAll(list)
//        Log.i("viewmodel сохранили", "$listViewModel")

//    }
    fun getData(): LiveData<List<MyModelCurrency>> {

        if (data == null) {
            data = MutableLiveData()
            loadData()
        }
        return data as MutableLiveData<List<MyModelCurrency>>

    }


        fun loadData() {
       // data?.value = currencyRepository.getAllCurrency()
        data?.setValue(currencyRepository.getAllCurrency())
        Log.i("loadData", "${currencyRepository.getAllCurrency()}")

    }
//    fun getData(): List<MyModelCurrency> {
//        Log.i("viewmodel получилиnnn", "$listViewModel")
//        return listViewModel
//
//    }
//
//    fun saveData(list: List<MyModelCurrency>) {
////        listViewModel = list.toMutableList()
////        listViewModel.addAll(list)
//        listViewModel.addAll(list)
//        Log.i("viewmodel получили", "$listViewModel")
//
//    }

//    fun getData(): List<MyModelCurrency> {
//       // Log.i("viewmodel вернули", "$listViewModel")
////        if (listViewModel.isEmpty()){
////            return null
////        }else{
//        return listViewModel
//        }

}



