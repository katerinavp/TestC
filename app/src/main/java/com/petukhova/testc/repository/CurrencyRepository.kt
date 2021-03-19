package com.petukhova.testc.repository

import com.petukhova.testc.model.MyModelCurrency


interface CurrencyRepository {

    fun saveListCurrency(list: List<MyModelCurrency>)

    fun getAllCurrency(): List<MyModelCurrency>

}

