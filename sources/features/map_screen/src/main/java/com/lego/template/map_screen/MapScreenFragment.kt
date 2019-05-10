package com.lego.template.map_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lego.template.base.mvvm.BaseFragment
import com.lego.template.base.mvvm.BaseViewModel
import com.lego.template.map_screen.databinding.FragmentMapBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MapScreenFragment : BaseFragment() {

    private val viewModel: MapScreenViewModel by viewModel()

    private lateinit var binding: FragmentMapBinding

    override fun getViewModel(): BaseViewModel = viewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMapBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}