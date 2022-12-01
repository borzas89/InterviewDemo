package com.example.interviewdemo.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Language {
    @SerializedName("iso639_1")
    @Expose
    var iso6391: String? = ""

    @SerializedName("iso639_2")
    @Expose
    var iso6392: String? = ""

    @SerializedName("name")
    @Expose
    var name: String? = ""

    @SerializedName("nativeName")
    @Expose
    var nativeName: String? = ""
}