package com.example.interviewdemo.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RegionalBloc {
    @SerializedName("acronym")
    @Expose
    var acronym: String? = ""

    @SerializedName("name")
    @Expose
    var name: String? = ""
}