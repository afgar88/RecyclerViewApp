package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.recyclerviewapp.adapter.EventListener
import com.example.recyclerviewapp.views.FirstFragment
import com.example.recyclerviewapp.views.ThirdFragment

class MainActivity : AppCompatActivity(), EventListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            fragmentNavigation(supportFragmentManager, FirstFragment.newInstance("", ""))
        }
    }

    override fun listenerAnotherActi(index: Int) {
        fragmentNavigation(supportFragmentManager, ThirdFragment.newInstance(index))
        Log.d("FROM_MAIN","DATA ${index}")
    }
}