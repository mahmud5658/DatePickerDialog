package com.cyberx.datepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private TextView textView;

    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.buttonId);
        textView = (TextView) findViewById(R.id.textViewId);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        DatePicker datePicker = new DatePicker(this);

        int currentDate = datePicker.getDayOfMonth();
        int currentMonth = (datePicker.getDayOfMonth() + 1);
        int currentYear = datePicker.getYear();

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                textView.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            }
        }, currentYear, currentMonth, currentDate);

        datePickerDialog.show();
    }
}