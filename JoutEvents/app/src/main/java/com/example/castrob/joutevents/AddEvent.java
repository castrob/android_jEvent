package com.example.castrob.joutevents;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AddEvent extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextOrganizerName, editTextOrganizerPhone, editTextOrganizerEmail,
            editTextEventName, editTextEventBeginDate, editTextEventBeginTime, editTextEventEndDate,
            editTextEventEndTime;

    private Button buttonApply;

    int year_x, month_x, day_x;
    int year_y, month_y, day_y;
    static final int DIALOG_IDA = 0;
    static final int DIALOG_IDB = 1;
    Intent thisIntent;
    List<Event> events;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        this.thisIntent = getIntent();
        events = (List<Event>) thisIntent.getExtras().getSerializable("EXTRA_ADD");


        // initializing each edittext
        editTextOrganizerName = (EditText) findViewById(R.id.et_organizername);
        editTextOrganizerPhone = (EditText) findViewById(R.id.et_organizerphonenumber);
        editTextOrganizerEmail = (EditText) findViewById(R.id.et_organizeremail);
        //event
        editTextEventName = (EditText) findViewById(R.id.et_eventname);
        editTextEventBeginDate = (EditText) findViewById(R.id.et_eventbegindate);
        editTextEventBeginTime = (EditText) findViewById(R.id.et_eventbegintime);
        editTextEventEndDate = (EditText) findViewById(R.id.et_eventenddate);
        editTextEventEndTime = (EditText) findViewById(R.id.et_eventendtime);
        //button to apply
        buttonApply = (Button) findViewById(R.id.btn_addevent);

        final Calendar cal = Calendar.getInstance();

        year_x = cal.get(Calendar.YEAR);
        year_y = cal.get(Calendar.YEAR);
        day_x = cal.get(Calendar.DAY_OF_MONTH);
        day_y = cal.get(Calendar.DAY_OF_MONTH);
        month_x = cal.get(Calendar.MONTH);
        month_y = cal.get(Calendar.MONTH);

        showDialogOnEditTextClick();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                Toast.makeText(this, "LALALALALALALAL", Toast.LENGTH_LONG).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public Dialog onCreateDialog(int id){
        if(id == DIALOG_IDA){
            return new DatePickerDialog(this,dpickerListener,year_x,month_x,day_x);
        }else if (id == DIALOG_IDB){
            return new DatePickerDialog(this,dpickerListenerB,year_y,month_y,day_y);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerListenerB
            = new DatePickerDialog.OnDateSetListener(){

        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            year_y = i;
            month_y = i1+1;
            day_y = i2;
            editTextEventEndDate.setText(day_y + "/" + month_y + "/" + year_y);
        }
    };

    private DatePickerDialog.OnDateSetListener dpickerListener
            = new DatePickerDialog.OnDateSetListener(){

        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            year_x = i;
            month_x = i1+1;
            day_x = i2;
            editTextEventBeginDate.setText(day_x + "/" + month_x + "/" + year_x);
        }
    };

    public void showDialogOnEditTextClick(){
        editTextEventBeginDate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switch (view.getId()){
                            case R.id.et_eventbegindate:
                                    showDialog(DIALOG_IDA);
                                break;
                            case R.id.et_eventenddate:
                                showDialog(DIALOG_IDB);
                                break;
                        }
                    }
                }
        );

        editTextEventEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.et_eventbegindate:
                        showDialog(DIALOG_IDA);
                        break;
                    case R.id.et_eventenddate:
                        showDialog(DIALOG_IDB);
                        break;
                }
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.et_organizername:
                break;
            case R.id.et_organizerphonenumber:
                break;
            case R.id.et_organizeremail:
                break;
            case R.id.et_eventname:
                break;
            case R.id.et_eventbegindate:
                break;
            case R.id.et_eventbegintime:
                break;
            case R.id.et_eventenddate:
                break;
            case R.id.et_eventendtime:
                break;
            case R.id.btn_addevent:
                    String name = editTextOrganizerName.getText().toString();
                    String contact = editTextOrganizerPhone.getText().toString();
                    String email = editTextOrganizerEmail.getText().toString();
                    Invitee organizer = new Invitee(name,contact,email);
                    String eventname = editTextEventName.getText().toString();
                    String datebegin = editTextEventBeginDate.getText().toString() + " - " + editTextEventBeginTime.getText().toString();
                    String dateend = editTextEventEndDate.getText().toString() + " - " + editTextEventEndDate.getText().toString();
                    List<Invitee> inviteeList = new ArrayList<>();
                    Event event = new Event(eventname,datebegin,dateend,organizer,inviteeList);
                    events.add(event);
                    Intent goBackEvent = new Intent(this, EventActivity.class);
                    goBackEvent.putExtra("EXTRA_ADD", (Serializable) this.events);
                    setResult(RESULT_OK, goBackEvent);
                    finish();
                break;
        }
    }
}
