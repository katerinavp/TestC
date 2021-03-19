package com.petukhova.testc.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.petukhova.testc.databinding.RecyclerviewItemBinding
import com.petukhova.testc.model.MyModelCurrency

class AdapterCurrency :
    ListAdapter<MyModelCurrency, AdapterCurrency.CurrencyViewHolder>(ModelCurrencyDiffer) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder =
        CurrencyViewHolder(
            RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )


    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CurrencyViewHolder(
        private val binding: RecyclerviewItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(modelCurrency: MyModelCurrency) {
            with(binding) {
                infoDate.setText("Данные на")
               // currentDate.text = modelCurrency.date
                ticker.text = modelCurrency.charCode
                nameCurrency.text = modelCurrency.name
                value.text = modelCurrency.value.toString()

            }
        }

    }
}
