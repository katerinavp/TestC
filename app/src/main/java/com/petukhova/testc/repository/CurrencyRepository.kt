package com.petukhova.testc.repository

import com.petukhova.testc.model.MyModelCurrency


interface CurrencyRepository {

//    fun getAllCurrency(): MutableList<MyModelCurrency>?

    fun saveListCurrency(
        list: List<MyModelCurrency>){
    }
    fun getAllCurrency():List<MyModelCurrency>

}

