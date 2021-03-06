package com.petukhova.testc.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.petukhova.testc.adapter.AdapterCurrency
import com.petukhova.testc.databinding.ActivityMainBinding
import com.petukhova.testc.viewmodel.CurrencyViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(LayoutInflater.from(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val currencyViewModel: CurrencyViewModel =
            ViewModelProviders.of(this).get(CurrencyViewModel::class.java)

        val adapter = AdapterCurrency()
        binding.recyclerView.adapter = adapter

        //загрузка данных по кнопке
        binding.btnUpdate.setOnClickListener {
            binding.progressBar.isVisible = true
            lifecycleScope.launch { currencyViewModel.init() }
        }

        currencyViewModel.getData().observe(this, {
            binding.progressBar.isVisible = false
            adapter.submitList(it.toMutableList())
        })

    }

}








