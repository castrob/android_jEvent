package com.example.castrob.joutevents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<Invitee> inviteeList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        inviteeList = new ArrayList<>();
        Invitee contact = new Invitee("Joao Paulo","(31)99594-1208","jpcbpereira@sga.pucminas.br");
        inviteeList.add(contact);
        Invitee contact2 = new Invitee("Yan Humphreis","(31)98575-1203","yan.h.goncalves@sga.pucminas.br");
        inviteeList.add(contact2);

        adapter = new MyAdapter(inviteeList,this);
        recyclerView.setAdapter(adapter);
    }

    public void addPerson(View view) {
        Toast.makeText(MainActivity.this, "Add Contact", Toast.LENGTH_SHORT).show();
    }
}
