package com.example.recyclerviewapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp.R
import com.example.recyclerviewapp.model.Event
import java.util.zip.Inflater

class EventAdapter(
    private val eventList: MutableList<Event> = mutableListOf()
) : RecyclerView.Adapter<EventViewHolder>() {

    //this method will update our data set
    fun updateEventData(event: Event) {
        eventList.add(0,event)
        // this guy will notify adapter a new item has been introduces
        notifyItemInserted(eventList.lastIndexOf(event))
    }

    // here you are creating your view holder that hols your views to be bound
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        // Here i am inflating my EVENT ITEM coming from the XML file
        val evenView =
            LayoutInflater.from(parent.context).inflate(R.layout.event_item, parent, false)
        return EventViewHolder(evenView)
    }


    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = eventList[position]
        holder.bind(event)
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