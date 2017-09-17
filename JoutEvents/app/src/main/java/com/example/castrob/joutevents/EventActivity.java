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

public class EventActivity extends AppCompatActivity implements View.OnClickListener{

    public static final int ADD_EVENT = 0;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Event> eventList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        this.eventList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewEvent);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.eventList = (List<Event>) data.getExtras().getSerializable("EXTRA_ADD");
        adapter = new EventAdapter(this.eventList,this);
        recyclerView.setAdapter(adapter);
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
                newEvent.putExtra("EXTRA_ADD", (Serializable) this.eventList);
                startActivityForResult(newEvent,ADD_EVENT);
                break;
        }
    }
}
