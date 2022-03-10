package com.example.recyclerviewapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp.R
import com.example.recyclerviewapp.fragmentNavigation
import com.example.recyclerviewapp.model.Event
import com.example.recyclerviewapp.model.Events
import java.util.zip.Inflater

class EventAdapter(
    var eventListener: EventListener,
    private val eventList: MutableList<Event> = mutableListOf()
) : RecyclerView.Adapter<EventViewHolder>() {


    fun updateEventData(event: Event) {
        eventList.add(0, event)

        notifyItemInserted(eventList.indexOf(event))
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {

        val evenView =
            LayoutInflater.from(parent.context).inflate(R.layout.event_item, parent, false)

        return EventViewHolder(evenView)
    }


    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = eventList[position]
        holder.bind(event)
        holder.itemView.setOnClickListener {
        eventListener.listenerAnotherActi(position)
        }
    }


    override fun getItemCount(): Int = eventList.size
}

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val title: TextView = itemView.findViewById(R.id.event_title)
    private val category: TextView = itemView.findViewById(R.id.event_category)
    private val date: TextView = itemView.findViewById(R.id.event_date)

    fun bind(event: Event) {
        title.text = event.title
        category.text = event.category
        date.text = event.date

    }





}