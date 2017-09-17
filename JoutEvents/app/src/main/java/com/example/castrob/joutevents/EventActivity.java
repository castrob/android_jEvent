package com.example.castrob.joutevents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class EventActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Event> eventList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewEvent);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        eventList = new ArrayList<>();
        List<Invitee> inviteeList = new ArrayList<>();
        Invitee contact = new Invitee("Joao Paulo","(31)99594-1208","jpcbpereira@sga.pucminas.br");
        Invitee contact2 = new Invitee("Yan Humphreis","(31)98575-1203","yan.h.goncalves@sga.pucminas.br");
        inviteeList.add(contact);
        inviteeList.add(contact2);

        Invitee organizer = new Invitee("GDG BH", "(31) xxxx-xxxx", "gdgbh@gmail.com");
        Event eventOne = new Event("DevFest","November 18 - 08:00AM", "November 18 - 19:00PM", organizer, inviteeList);
        eventList.add(eventOne);

        adapter = new EventAdapter(eventList,this);
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
                Toast.makeText(EventActivity.this, "Add Event", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
