package com.example.interviewdemo.network

import com.google.gson.annotations.SerializedName

class Currency {
    @SerializedName("code")
    var code: String? = ""

    @SerializedName("name")
    var name: String? = ""

    @SerializedName("symbol")
    var symbol: String? = ""
}