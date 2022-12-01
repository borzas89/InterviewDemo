package com.example.interviewdemo.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.interviewdemo.databinding.FragmentListBinding
import com.example.interviewdemo.navigation.AppNavigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class ListFragment: Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ListViewModel by viewModels()

    @Inject
    lateinit var navigator: AppNavigator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.apply {
            viewModel = this@ListFragment.viewModel
        }

        binding.adapter = ListAdapter(listOf())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnTaskOne.setOnClickListener {
            navigator.navigateToTaskOne()
        }

        binding.btnSearch.setOnClickListener {
            viewModel.searchCountries()
        }
    }

}