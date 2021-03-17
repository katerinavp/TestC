package com.petukhova.testc.adapter

import androidx.recyclerview.widget.DiffUtil
import com.petukhova.testc.model.ModelCurrency

object ModelCurrencyDiffer: DiffUtil.ItemCallback<ModelCurrency>() {
    override fun areItemsTheSame(oldItem: ModelCurrency, newItem: ModelCurrency): Boolean =
            oldItem.CharCode == newItem.CharCode


    override fun areContentsTheSame(oldItem: ModelCurrency, newItem: ModelCurrency): Boolean = oldItem == newItem
}
