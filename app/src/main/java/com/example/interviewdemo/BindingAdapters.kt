package com.example.interviewdemo

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.interviewdemo.arch.BaseModel
import example.com.totalnba.arch.BaseAdapter

object BindingAdapters {
    @JvmStatic
    @BindingAdapter(value = ["isVisibleOrGone"], requireAll = false)
    fun isVisibleOrGone(view: View, isVisible: Boolean?) {
        view.visibility = if (isVisible == true) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter(value = ["isVisibleOrInvisible"], requireAll = false)
    fun isVisibleOrInvisible(view: View, isVisible: Boolean?) {
        view.visibility = if (isVisible == true) View.VISIBLE else View.INVISIBLE
    }

    @JvmStatic
    @BindingAdapter("setAdapter")
    fun setAdapter(
        recyclerView: RecyclerView,
        adapter: BaseAdapter<ViewDataBinding, BaseModel>?
    ) {
        adapter?.let {
            recyclerView.adapter = it
        }
    }

    @JvmStatic
    @Suppress("UNCHECKED_CAST")
    @BindingAdapter("submitList")
    fun submitList(recyclerView: RecyclerView, list: List<BaseModel>?) {
        val adapter = recyclerView.adapter as BaseAdapter<ViewDataBinding, BaseModel>?
        adapter?.updateData(list ?: listOf())
    }

    @JvmStatic
    @BindingAdapter("image_url")
    fun loadImage(imageView: ImageView, url: String) {
        Glide.with(imageView.context)
            .load(url)
            .placeholder(R.drawable.ic_launcher_foreground)
            .circleCrop()
            .thumbnail()
            .into(imageView)
    }
}