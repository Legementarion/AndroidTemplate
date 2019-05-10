package com.lego.template.recycle_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lego.template.base.mvvm.BaseFragment
import com.lego.template.base.mvvm.BaseViewModel
import com.lego.template.recycle_screen.databinding.FragmentRecyclerBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecycleScreenFragment : BaseFragment() {

    private val viewModel: RecycleScreenViewModel by viewModel()

    private lateinit var binding: FragmentRecyclerBinding

    override fun getViewModel(): BaseViewModel = viewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}