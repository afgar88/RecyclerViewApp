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
import com.example.recyclerviewapp.R
import com.example.recyclerviewapp.adapter.EventAdapter
import com.example.recyclerviewapp.adapter.EventListener
import com.example.recyclerviewapp.databinding.FragmentSecondBinding
import com.example.recyclerviewapp.fragmentNavigation
import com.example.recyclerviewapp.model.Event
import com.example.recyclerviewapp.model.Events


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var eventList: EventListener


    private val eventAdapter by lazy {
        EventAdapter(eventList)
    }
    val calendar = Calendar.getInstance()
    val dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM)
    private var date: String = ""

    private val binding by lazy {
        FragmentSecondBinding.inflate(layoutInflater)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        eventList = activity as EventListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.eventCalendar.setOnDateChangeListener { calendarView, i, i2, i3 ->
            calendar.set(i, i2, i3)
            date = dateFormatter.format(calendar.time).toString()


            Log.d("DATE", calendar.time.toString())

        }


        binding.doneBtn.setOnClickListener {

            var event =
                Event("${binding.eventTitleEt.text}", "${binding.eventCategoryEt.text}", date)
            Events.add(event)

            fragmentNavigation(
                supportFragmentManager = requireActivity().supportFragmentManager,
                FirstFragment.newInstance("", "")
            )

        }

        return binding.root
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_second, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}