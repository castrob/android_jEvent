package com.example.castrob.joutevents;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by castro on 15/09/17.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder>{


    private List<Event> eventList;
    private EventClickListener eventClickListener;

    public EventAdapter(){
        this.eventList = new ArrayList<>();
        this.eventClickListener = null;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Event event = eventList.get(position);
        Invitee organizer = event.getOrganizer();
        holder.textViewNameEvent.setText(event.getEventName());
        holder.textViewNameOrganizer.setText(organizer.getName());
        holder.textViewOganizerFone.setText(organizer.getContact());
        holder.textViewEventDate.setText(event.getDateBegin());
    }

    /**
     * Updates the content of the RecyclerView
     * @param eventList new list of Event
     */
    public void update(List<Event> eventList){
        if (eventList != null){
            this.eventList = eventList;
        }

        notifyDataSetChanged();
    }

    /**
     * Updates the content of the RecyclerView adding a new Event
     * @param newEvent Event to be added
     */
    public void add(Event newEvent){
        if (newEvent != null){
            this.eventList.add(newEvent);
        }

        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textViewNameEvent;
        public TextView textViewNameOrganizer;
        public TextView textViewOganizerFone;
        public TextView textViewEventDate;

        public ViewHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            textViewNameEvent = itemView.findViewById(R.id.tv_eventname);
            textViewNameOrganizer = itemView.findViewById(R.id.tv_organizername);
            textViewOganizerFone = itemView.findViewById(R.id.tv_organizerfone);
            textViewEventDate = itemView.findViewById(R.id.tv_eventdate);
        }

        @Override
        public void onClick(View view) {
            if (eventClickListener != null) {
                eventClickListener.onEventClick(eventList.get(getAdapterPosition()));
            }
        }
    }

    public interface EventClickListener {
        /**
         * Called when a Event is clicked.
         * @param event Clicked event
         */
        void onEventClick(Event event);
    }

}
