package com.example.castrob.joutevents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class InviteeActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<Invitee> inviteeList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitee);
        Intent thisIntent = getIntent();
        Event thisEvent = (Event) thisIntent.getExtras().getSerializable("EXTRA_EVENT");
        inviteeList = thisEvent.getInviteeList();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new InviteeAdapter(inviteeList ,this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab_addinvitee:
                Toast.makeText(InviteeActivity.this, "Add Contact", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_removeInvitee:
                Toast.makeText(InviteeActivity.this, "Remove Invitee", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_sendmessage:
                Toast.makeText(InviteeActivity.this, "Send Wpp Message", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
