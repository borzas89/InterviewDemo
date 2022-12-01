package com.example.interviewdemo.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Flags {
    @SerializedName("svg")
    @Expose
    var svg: String? = ""

    @SerializedName("png")
    @Expose
    var png: String? = ""
}