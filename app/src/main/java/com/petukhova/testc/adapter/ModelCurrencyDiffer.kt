package com.petukhova.testc.adapter

import androidx.recyclerview.widget.DiffUtil
import com.petukhova.testc.model.MyModelCurrency

object ModelCurrencyDiffer: DiffUtil.ItemCallback<MyModelCurrency>() {
    override fun areItemsTheSame(oldItem: MyModelCurrency, newItem: MyModelCurrency): Boolean =
            oldItem.value == newItem.value


    override fun areContentsTheSame(oldItem: MyModelCurrency, newItem: MyModelCurrency): Boolean = oldItem == newItem
}
