package com.example.castrob.joutevents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EventActivity extends AppCompatActivity
        implements View.OnClickListener, EventAdapter.EventClickListener {

    public static final int ADD_EVENT = 0;
    private RecyclerView recyclerView;
    private EventAdapter adapter;
    private List<Event> eventList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        this.eventList = new ArrayList<>();
        this.adapter = new EventAdapter();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewEvent);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(this.adapter);
        //recyclerView.setHasFixedSize(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Analyze wich request has ended
        switch (requestCode) {
            case ADD_EVENT:

                // If the result was successful
                if (resultCode == RESULT_OK) {
//                    this.eventList = (List<Event>) data.getExtras().getSerializable("EXTRA_ADD");
//                    adapter.update(this.eventList);
//                    recyclerView.setAdapter(adapter);

                    // This ways is better
                    Event receivedEvent = (Event) data.getExtras().getSerializable("EXTRA_ADD");
                    adapter.add(receivedEvent);
                }
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_createfacebookevent:
                Toast.makeText(EventActivity.this, "Create Facebook Event", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_createlinkedinevent:
                Toast.makeText(EventActivity.this, "Create Linkedin Event", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab_addevent:
                Intent newEvent = new Intent(this, AddEvent.class);
//                newEvent.putExtra("EXTRA_ADD", (Serializable) this.eventList);
                startActivityForResult(newEvent,ADD_EVENT);
                break;
        }
    }

    @Override
    public void onEventClick(Event event) {
        Intent intent = new Intent(this, InviteeActivity.class);
        intent.putExtra("EXTRA_EVENT", event);
        startActivity(intent);
    }
}
