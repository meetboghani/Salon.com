package com.abc.saloncom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Calendar;

public class booking1 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private Button button;
    private ImageButton button2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking1);

        Intent intent = getIntent();
        String final_cat2 = intent.getStringExtra(Relief.Extra_text2);

        TextView textview3 = (TextView) findViewById(R.id.textView3);

        textview3.setText(final_cat2);
        button2 = (ImageButton) findViewById(R.id.image3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datepicker = new DatePickerFragement();
                datepicker.show(getSupportFragmentManager(), "date picker");
            }
        });


        button = (Button) findViewById(R.id.button12);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openconfirmdetails();
            }

                   });

    }
    private void openconfirmdetails()
    {
        Intent intent = new Intent(booking1.this, confirmdetails.class);
        startActivity(intent);

    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayofMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH,dayofMonth);
        String currentDateString = DateFormat.getDateInstance().format(c.getTime());

        TextView textView = (TextView) findViewById(R.id.textView6);
        textView.setText(currentDateString);
    }
}
