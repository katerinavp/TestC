package com.petukhova.testc.repository

import android.util.Log
import com.google.gson.Gson
import com.petukhova.testc.model.MyModelCurrency
import splitties.toast.toast
import java.io.*
import java.util.*

object CurrencyRepositoryImpl : CurrencyRepository {
    private var listCurrency: MutableList<MyModelCurrency> = mutableListOf()

    override fun saveListCurrency(list: List<MyModelCurrency>) {
        listCurrency.clear()
        listCurrency.addAll(list)

        Log.i("saveListCurrency", "$listCurrency")
        Log.i("getAllCurrency", "$listCurrency")
        //Log.i("getAllCurrency", "$listCurrency")

    }

    override fun getAllCurrency(): List<MyModelCurrency> {
        Log.i("saveListCurrency", "$listCurrency")
        Log.i("getAllCurrency", "$listCurrency")
        return listCurrency
    }


}