package com.abc.saloncom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import static com.abc.saloncom.A1_hair.final_cat;

public class booking extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {


    private ImageButton button1;
    private EditText edittextview;
    private Button button11;
    FirebaseAuth firebaseAuth;
    private ProgressBar progressBar;
    private Task<Void> Databasereference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        //textView = findViewById(R.id.textView2);
        //textView = findViewById(R.id.textView3);

        edittextview = (EditText) findViewById(R.id.editView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);


        Intent intent = getIntent();
        String final_cat = intent.getStringExtra(A1_hair.Extra_text);
        //String final_cat1 = intent.getStringExtra(Sports.Extra_text1);
        //String final_cat2 = intent.getStringExtra(Relief.Extra_text2);
        //String text1 = intent.getStringExtra(A1_hair.Extra_text1);

        //TextView textview1 = (TextView) findViewById(R.id.textView3);
        TextView textview2 = (TextView) findViewById(R.id.textView2);
        //TextView textview3 = (TextView) findViewById(R.id.textView2);
        //TextView textview4 = (TextView) findViewById(R.id.textView2);
        //textview2.setEnabled(false);

        textview2.setText(final_cat);
        //textview3.setText(final_cat1);
        //textview4.setText(final_cat2);
        button1 = (ImageButton) findViewById(R.id.image3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datepicker = new DatePickerFragement();
                datepicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        button11 = (Button) findViewById(R.id.button11);



        /*button11 = (Button) findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openconfirmdetails();
            }
        });*/


        firebaseAuth = FirebaseAuth.getInstance();
    }


    /*private void openconfirmdetails() {


        Intent intent = new Intent(this, confirmdetails.class);
        startActivity(intent);
    }*/


    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayofMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayofMonth);
        String currentDateString = DateFormat.getDateInstance().format(c.getTime());

        EditText edittextview = (EditText) findViewById(R.id.editView);
        edittextview.setText(currentDateString);
    }


    private void registerUser1() {
        final String date = edittextview.getText().toString().trim();

        if (TextUtils.isEmpty(date)) {

            //email is empty
            Toast.makeText(this, "Please enter Date", Toast.LENGTH_SHORT).show();
            //stopping the Execution further
            return;
        } else {
            Toast.makeText(this, "entered date ", Toast.LENGTH_SHORT).show();
            //stopping the execution further
            finish();
            startActivity(new Intent(this, confirmdetails.class));

        }


        progressBar.setVisibility(View.VISIBLE);

        progressBar.setVisibility(View.GONE);
        Task task = null;
        if (task.isSuccessful()) {

            User info = new User(date);

            Databasereference = FirebaseDatabase.getInstance().getReference("user")
                    .child(firebaseAuth.getCurrentUser().getUid())
                    .setValue(info).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            Toast.makeText(booking.this, "Done successfully", Toast.LENGTH_SHORT).show();

                            finish();
                            startActivity(new Intent(booking.this, confirmdetails.class));

                        }
                    });


        } else {
            Toast.makeText(booking.this, "Could not registered ,Please check internet connection", Toast.LENGTH_SHORT).show();
        }
    }


    public void onClick(View v) {

        if (v == button11) {

            registerUser1();
        }
    }


}

