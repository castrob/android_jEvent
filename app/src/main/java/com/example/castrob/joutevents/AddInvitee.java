package com.example.castrob.joutevents;

import android.app.ActionBar;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
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
        thisEvent = (Event) thisIntent.getExtras().getSerializable("EXTRA_ADD");
        invitees = thisEvent != null ? thisEvent.getInviteeList() : null;

        editTextName = (EditText) findViewById(R.id.et_name);
        editTextPhone = (EditText) findViewById(R.id.et_phonenumber);
        editTextEmail = (EditText) findViewById(R.id.et_email);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent goBackIntent = new Intent(this, EventActivity.class);
                goBackIntent.putExtra("EXTRA_ADD", (Serializable) thisEvent);
                setResult(RESULT_OK,goBackIntent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick (View view){
        Intent goBackIntent = new Intent(this, InviteeActivity.class);
        String name, phone, email;
        if(editTextName.getText().toString().trim().equals("")){
            editTextName.setError("Favor preencher campo Nome!");
        }else{
            // testing if phone is filled
            if(editTextPhone.getText().toString().trim().equals("")){
                editTextPhone.setError("Favor preencher campo Telefone!");
            }else{
                //testing if email is filled
                if(editTextEmail.getText().toString().trim().equals("")){
                    editTextEmail.setError("Favor preencher campo Email!");
                }else{
                    email = editTextEmail.getText().toString();
                    phone = editTextPhone.getText().toString();
                    name = editTextName.getText().toString();


                    Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                    //mudando o nome
                    intent.putExtra(ContactsContract.Intents.Insert.NAME, name);

                    //mudando o telefone
                    intent.putExtra(ContactsContract.Intents.Insert.PHONE, phone);
                    intent.putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_HOME);

                    intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
                    startActivity(intent);

                    Invitee newInvitee = new Invitee(name,phone,email);
                    invitees.add(newInvitee);
                    thisEvent.setInviteeList(invitees);
                    goBackIntent.putExtra("EXTRA_ADD",thisEvent);
                    setResult(RESULT_OK,goBackIntent);
                    finish();
                }
            }
        }

    }
}
