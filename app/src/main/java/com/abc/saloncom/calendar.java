package com.abc.saloncom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;

class calendar extends AppCompatActivity {

    CalendarView c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        c = (CalendarView) findViewById(R.id.calendar);
        c.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                String date = i2 + "/" + i1 + "/" + i;

                Intent intent = new Intent(calendar.this, navigation.class);
                intent.putExtra("SelectedDate", date);
                startActivity(intent);

            }
        });

    }
}

