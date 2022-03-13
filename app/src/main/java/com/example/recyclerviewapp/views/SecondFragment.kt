package com.example.recyclerviewapp.views

import android.content.Context
import android.icu.text.DateFormat
import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.example.recyclerviewapp.R
import com.example.recyclerviewapp.adapter.EventAdapter
import com.example.recyclerviewapp.adapter.EventListener
import com.example.recyclerviewapp.databinding.FragmentSecondBinding
import com.example.recyclerviewapp.fragmentNavigation
import com.example.recyclerviewapp.model.Event
import com.example.recyclerviewapp.model.Events
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class SecondFragment : Fragment() {

    lateinit var eventList: EventListener

    val calendar = Calendar.getInstance()
    val dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM)
   // private var date: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"))
    private var date: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM/dd/yyyy"))

    private val binding by lazy {
        FragmentSecondBinding.inflate(layoutInflater)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        eventList = activity as EventListener
        binding.doneBtn.isEnabled = false
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.eventCalendar.setOnDateChangeListener { calendarView, i, i2, i3 ->
            calendar.set(i, i2, i3)
            date = dateFormatter.format(calendar.time).toString()
        }

        binding.eventTitleEt.addTextChangedListener {
           validateFiels()
        }
        binding.eventCategoryEt.addTextChangedListener {
           validateFiels()
        }

        binding.doneBtn.setOnClickListener {

            var event =
                Event("${binding.eventTitleEt.text}", "${binding.eventCategoryEt.text}", date)
            Events.add(event)

            fragmentNavigation(
                supportFragmentManager = requireActivity().supportFragmentManager,
                FirstFragment.newInstance()
            )

        }

        return binding.root
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_second, container, false)
    }

    fun validateFiels() {
        if (binding.eventTitleEt.text.isNotEmpty() || binding.eventCategoryEt.text.isNotEmpty()){
            binding.doneBtn.isEnabled=true
        }
    }

    companion object {
        fun newInstance() = SecondFragment()
    }
}