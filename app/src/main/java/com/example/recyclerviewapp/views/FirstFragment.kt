package com.example.recyclerviewapp.views

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewapp.R
import com.example.recyclerviewapp.adapter.EventAdapter
import com.example.recyclerviewapp.adapter.EventListener
import com.example.recyclerviewapp.databinding.FragmentFirstBinding
import com.example.recyclerviewapp.fragmentNavigation
import com.example.recyclerviewapp.model.Event
import com.example.recyclerviewapp.model.Events

class FirstFragment : Fragment() {

    lateinit var eventList: EventListener

    private val binding by lazy {
        FragmentFirstBinding.inflate(layoutInflater)
    }

    private val eventAdapter by lazy {
        EventAdapter(eventList)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        eventList = activity as EventListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        for (i in 0 until Events.size) {
            eventAdapter.updateEventData(Events[i])
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.myRecycler.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = eventAdapter
        }

        binding.addEvent.setOnClickListener {
            fragmentNavigation(
                supportFragmentManager = requireActivity().supportFragmentManager,
                SecondFragment.newInstance()
            )
        }

        return binding.root
    }

    companion object {
        fun newInstance() = FirstFragment()
    }
}