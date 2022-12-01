package com.example.interviewdemo.ui.list

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.interviewdemo.arch.BaseViewModel
import com.example.interviewdemo.network.Country
import com.example.interviewdemo.network.RestCountriesApi
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val restCountriesApi: RestCountriesApi
) : BaseViewModel() {
    val errorTitle = ObservableField<String>()
    private val _countryList = MutableLiveData<List<Country>>()
    val countryList: LiveData<List<Country>> = _countryList

    fun searchCountries(){
        resetList()
        restCountriesApi.getEuropeanCountries()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .simpleSubscribe(
                onSuccess = {
                    _countryList.value = it
                },
                onError = {
                    errorTitle.set("Something went wrong...")
                }).addTo(compositeDisposable)
    }

    fun resetList(){
        emptyViewVisible.set(true)
        listViewVisible.set(false)
        _countryList.value = emptyList()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}