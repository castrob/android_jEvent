package com.example.castrob.joutevents;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class AddInvitee extends AppCompatActivity {

    private Intent thisIntent;
    private EditText editTextName;
    private EditText editTextPhone;
    private EditText editTextEmail;
    private List<Invitee> invitees;
    private Event thisEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_invitee);
        thisIntent = getIntent();
        thisEvent = (Event) thisIntent.getExtras().getSerializable("EVENT_ADD");
        invitees = thisEvent != null ? thisEvent.getInviteeList() : null;

        editTextName = (EditText) findViewById(R.id.et_name);
        editTextPhone = (EditText) findViewById(R.id.et_phonenumber);
        editTextEmail = (EditText) findViewById(R.id.et_email);
    }

    public void onClick (View view){
        Intent goBackIntent = new Intent(this, InviteeActivity.class);
        String name, phone, email;
        if(editTextName.getText().toString().trim().equals("")){
            editTextName.setError("Favor preencher campo Nome!");
        }else{
            name = editTextName.getText().toString();
            // testing if phone is filled
            if(editTextPhone.getText().toString().trim().equals("")){
                editTextPhone.setError("Favor preencher campo Telefone!");
            }else{
                phone = editTextPhone.getText().toString();
                //testing if email is filled
                if(editTextEmail.getText().toString().trim().equals("")){
                    editTextEmail.setError("Favor preencher campo Email!");
                }else{
                    email = editTextEmail.getText().toString();
                    Invitee newInvitee = new Invitee(name,phone,email);
                    invitees.add(newInvitee);
                    thisEvent.setInviteeList(invitees);
                    goBackIntent.putExtra("EXTRA_EVENT",thisEvent);
                    setResult(RESULT_OK,goBackIntent);
                }
            }
        }

    }
}
