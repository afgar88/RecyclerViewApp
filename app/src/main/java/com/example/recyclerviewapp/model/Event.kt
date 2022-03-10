package com.example.recyclerviewapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*


data class Event(
    val title:String,
    val category:String,
    val date:String
)

