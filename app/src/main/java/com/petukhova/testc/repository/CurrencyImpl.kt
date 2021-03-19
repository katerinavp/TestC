package com.petukhova.testc.repository

import android.util.Log
import com.google.gson.Gson
import com.petukhova.testc.model.MyModelCurrency
import splitties.toast.toast
import java.io.*
import java.util.*

class CurrencyImpl : CurrencyRepository {
    var listCurrency: MutableList<MyModelCurrency> = mutableListOf()
    //val currencyViewModel = CurrencyViewModel()

    override fun saveListCurrency(list: List<MyModelCurrency>) {
        // listCurrency = mutableListOf()
        //val selectedSeries = series.toMutableList()
        listCurrency.addAll(list)

        Log.i("saveListCurrency", "$listCurrency")
        Log.i("getAllCurrency", "$listCurrency")

    }

    override fun getAllCurrency(): List<MyModelCurrency> = listCurrency

}