package com.example.interviewdemo.ui.taskOne

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.interviewdemo.databinding.FragmentTaskOneBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskOneFragment: Fragment() {

    private var _binding: FragmentTaskOneBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TaskOneViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskOneBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.apply {
            viewModel = this@TaskOneFragment.viewModel
        }

        return binding.root
    }

}