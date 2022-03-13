package com.example.recyclerviewapp.views

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recyclerviewapp.R
import com.example.recyclerviewapp.adapter.EventAdapter
import com.example.recyclerviewapp.adapter.EventListener
import com.example.recyclerviewapp.databinding.FragmentThirdBinding
import com.example.recyclerviewapp.model.Events

private const val ARG_PARAM1 = "param1"

class ThirdFragment : Fragment() {
    private var param1: Int= 0

    private val binding by lazy {
        FragmentThirdBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.detailsEvent.text = ("TITTLE: ${Events[param1].title}\n"+"CATEGORY: ${Events[param1].category}\n"+"DATE: ${Events[param1].date}\n")

        return binding.root
    }

    companion object {
        fun newInstance(param1: Int) =
            ThirdFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                }
            }
    }


}