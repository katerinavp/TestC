package com.petukhova.testc.repository

import com.petukhova.testc.model.MyModelCurrency


object CurrencyRepositoryImpl : CurrencyRepository {
    private var listCurrency: MutableList<MyModelCurrency> = mutableListOf()

    override fun saveListCurrency(list: List<MyModelCurrency>) {
        listCurrency.clear()
        listCurrency.addAll(list)

    }

    override fun getAllCurrency(): List<MyModelCurrency> = listCurrency



}