package com.petukhova.testc.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.petukhova.testc.databinding.RecyclerviewItemBinding
import com.petukhova.testc.model.ModelCurrency

class AdapterCurrency : ListAdapter<ModelCurrency, AdapterCurrency.CurrencyViewHolder>(ModelCurrencyDiffer) {

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

        fun bind(modelCurrency: ModelCurrency) {
            with(binding) {
                ticker.text = modelCurrency.CharCode
                nameCurrency.text = modelCurrency.Name
                value.text = modelCurrency.Value.toString()
//                currentDate.text = modelCurrency.

            }
        }
    }

}
