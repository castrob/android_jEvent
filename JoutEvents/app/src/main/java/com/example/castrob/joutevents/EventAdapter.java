package com.example.castrob.joutevents;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by castro on 15/09/17.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder>{


    private List<Event> eventList;
    private Context context;

    public EventAdapter(List<Event> eventList, Context context){
        this.eventList = eventList;
        this.context = context;
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
            textViewNameEvent = (TextView) itemView.findViewById(R.id.tv_eventname);
            textViewNameOrganizer = (TextView) itemView.findViewById(R.id.tv_organizername);
            textViewOganizerFone = (TextView) itemView.findViewById(R.id.tv_organizerfone);
            textViewEventDate = (TextView) itemView.findViewById(R.id.tv_eventdate);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, InviteeActivity.class);
            intent.putExtra("EXTRA_EVENT", eventList.get(getAdapterPosition()));
            context.startActivity(intent);
        }
    }

}
