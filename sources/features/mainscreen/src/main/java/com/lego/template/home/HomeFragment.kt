package com.lego.template.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lego.template.base.mvvm.BaseFragment
import com.lego.template.base.mvvm.BaseViewModel
import com.lego.template.mainscreen.R
import com.lego.template.mainscreen.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.motion_start.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment() {

    private val viewModel: HomeViewModel by viewModel()
    private lateinit var binding: FragmentHomeBinding

    override fun getViewModel(): BaseViewModel = viewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iconBtn.setOnClickListener { openNextScreen() }
    }

    private fun openNextScreen() {
        if (motionContainer.currentState == R.layout.motion_end) {
            motionContainer.transitionToStart()
        } else {
            motionContainer.transitionToEnd()
        }
    }

}