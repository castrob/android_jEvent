package com.example.castrob.joutevents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class InviteeActivity extends AppCompatActivity implements View.OnClickListener{

    public static final int ADD_INVITEE = 10;
    public static final int RESULT_OK = 12;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private Event thisEvent;
    private Intent thisIntent;
    private List<Invitee> inviteeList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitee);
        thisIntent = getIntent();
        thisEvent = (Event) thisIntent.getExtras().getSerializable("EXTRA_EVENT");
        inviteeList = thisEvent.getInviteeList();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new InviteeAdapter(inviteeList ,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            Event event = (Event) data.getExtras().getSerializable("EXTRA_ADD");
            this.thisEvent = event;
            adapter = new InviteeAdapter(event.getInviteeList(),this);
            recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab_addinvitee:
                Intent addInvitee = new Intent(this, AddInvitee.class);
                addInvitee.putExtra("EXTRA_ADD", this.thisEvent);
                startActivityForResult(addInvitee, ADD_INVITEE);
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
