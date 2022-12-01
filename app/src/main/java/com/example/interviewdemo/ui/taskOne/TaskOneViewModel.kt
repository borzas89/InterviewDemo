package com.example.interviewdemo.ui.taskOne

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.interviewdemo.arch.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class TaskOneViewModel @Inject constructor(
) : BaseViewModel() {

    val inputText = ObservableField("")
    val displayedNumbers = ObservableField("")
    val numberList: MutableList<String> = mutableListOf()

    private val _numbersList = MutableLiveData<List<String>>()
    val numbersList: LiveData<List<String>> = _numbersList

    init {
        inputText
            .toFlowable()
            .debounce(125L, TimeUnit.MILLISECONDS, Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy {
                if (!it.equals("")) {
                    if(!it.equals("-")){
                        numberList.add(it)
                      //  _numbersList.value = numberList
                    }
                }
            }.addTo(compositeDisposable)
    }

    fun emittingNumbers(){
        _numbersList.value = numberList
        val sb = StringBuilder()
        numbersList.value?.let {
            it.forEach {
                if (it.contains("-")){
                    displayedNumbers.set(sb.append("negatív szám").toString())
                }
                for (i in 1..it.toInt()){
                    displayedNumbers.set(sb.append("RX ").toString())
                }
                displayedNumbers.set(sb.append("\n").toString())
            }
        }
    }
}