package com.example.interviewdemo.network

import com.example.interviewdemo.arch.BaseModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name")
    var name: String? = "",

    @SerializedName("topLevelDomain")
    var topLevelDomain: List<String>? = emptyList(),

    @SerializedName("alpha2Code")
    var alpha2Code: String? = "",

    @SerializedName("alpha3Code")
    var alpha3Code: String? = "",

    @SerializedName("callingCodes")
    var callingCodes: List<String>? = emptyList(),

    @SerializedName("capital")
    var capital: String? = "",

    @SerializedName("altSpellings")
    var altSpellings: List<String>? = emptyList(),

    @SerializedName("subregion")
    var subregion: String? = "",

    @SerializedName("region")
    var region: String? = "",

    @SerializedName("population")
    var population: String = "",

    @SerializedName("latlng")
    var latlng: List<Double>? = emptyList(),

    @SerializedName("demonym")
    var demonym: String? = "",

    @SerializedName("area")
    var area : String? = "",

    @SerializedName("timezones")
    var timezones: List<String>? = emptyList(),

    @SerializedName("nativeName")
    var nativeName: String? = "",

    @SerializedName("numericCode")
    var numericCode: String? = "",

    @SerializedName("flags")
    var flags: Flags? = null,

    @SerializedName("currencies")
    var currencies: List<Currency>? = emptyList(),

    @SerializedName("languages")
    var languages: List<Language>? = emptyList(),

    @SerializedName("translations")
    var translations: Translations? = null,

    @SerializedName("flag")
    var flag: String? = "",

    @SerializedName("regionalBlocs")
    var regionalBlocs: List<RegionalBloc>? = emptyList(),

    @SerializedName("independent")
    var isIndependent: Boolean = false
): BaseModel{
    val flagUrl get() =  flags?.let {
        it.png
    }
}