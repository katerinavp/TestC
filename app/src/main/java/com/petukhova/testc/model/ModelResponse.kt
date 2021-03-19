package com.petukhova.testc.model

import com.google.gson.annotations.SerializedName

//формат ответа от сервера
data class ModelResponse(
    @SerializedName("Date") val date: String,
    @SerializedName("PreviousDate") val previousDate: String,
    @SerializedName("PreviousURL") val previousURL: String,
    @SerializedName("Timestamp") val timestamp: String,
    @SerializedName("Valute") val valute: Map<String, Currency>
)