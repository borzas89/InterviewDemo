package com.example.interviewdemo.ui.list

import com.example.interviewdemo.R
import com.example.interviewdemo.databinding.ListItemCountryBinding
import com.example.interviewdemo.network.Country
import example.com.totalnba.arch.BaseAdapter

class ListAdapter(
    private val list: List<Country>,
) : BaseAdapter<ListItemCountryBinding, Country>(list) {

    override val layoutId: Int = R.layout.list_item_country

    override fun bind(binding: ListItemCountryBinding, item: Country) {
        binding.apply {
            country = item
            executePendingBindings()
        }
    }
}