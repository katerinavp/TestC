package com.petukhova.testc.ui

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.petukhova.testc.databinding.ActivityConvertBinding
import org.json.JSONObject


class ConvertActivity: AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityConvertBinding.inflate(LayoutInflater.from(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }

   private fun setSpinner(){

   }
}