package com.abc.saloncom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class booking3 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private Button button;
    private ImageButton button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking3);
        Intent intent = getIntent();
        String final_cat3 = intent.getStringExtra(Sports.Extra_text1);

        TextView textview4 = (TextView) findViewById(R.id.textView5);

        textview4.setText(final_cat3);

        button3 = (ImageButton) findViewById(R.id.image3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datepicker = new DatePickerFragement();
                datepicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openconfirmdetails();
            }

        });
    }
    private void openconfirmdetails()
    {
        Intent intent = new Intent(booking3.this, confirmdetails.class);
        startActivity(intent);

    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayofMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH,dayofMonth);
        String currentDateString = DateFormat.getDateInstance().format(c.getTime());

        TextView textView = (TextView) findViewById(R.id.textView7);
        textView.setText(currentDateString);

    }
}
