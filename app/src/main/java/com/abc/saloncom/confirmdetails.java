package com.abc.saloncom;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class confirmdetails extends AppCompatActivity {

    private Button button;
    private EditText editTextdate;
    private EditText editTextcard;
    private EditText editTextcvv, editTextname;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmdetails);
        button = (Button) findViewById(R.id.pay);

        editTextcvv = (EditText) findViewById(R.id.CVV);
        editTextdate = (EditText) findViewById(R.id.date);
        editTextcard = (EditText) findViewById(R.id.cardno);
        editTextname = (EditText) findViewById(R.id.name);


    }
    private void registerUser() {

        final String Name = editTextname.getText().toString().trim();
        final String cvv = editTextcvv.getText().toString().trim();
        String ExpiryDate = editTextdate.getText().toString().trim();
        final String cardno = editTextcard.getText().toString().trim();

        if (TextUtils.isEmpty(Name)) {

            //email is empty
            Toast.makeText(this, "Please enter Name", Toast.LENGTH_SHORT).show();
            //stopping the Execution further
            return;
        }
        if (TextUtils.isEmpty(cardno)) {

            //Password is empty
            Toast.makeText(this, "Please enter  Card No", Toast.LENGTH_SHORT).show();
            //stopping the execution further
            return;
        }
        if (cardno.length() != 14 ) {

            Toast.makeText(this, "Length of the Card Number must be 12 ", Toast.LENGTH_SHORT).show();
            //stopping the execution further
            return;
        }



        if (TextUtils.isEmpty(ExpiryDate)) {

            //Password is empty
            Toast.makeText(this, "Please enter Expiry Date", Toast.LENGTH_SHORT).show();
            //stopping the execution further
            return;
        }

        if (TextUtils.isEmpty(cvv)) {

            //email is empty
            Toast.makeText(this, "Please enter CVV", Toast.LENGTH_SHORT).show();
            //stopping the Execution further
            return;
        }


        if (cvv.length() != 3 ) {

            Toast.makeText(this, "Length of the CVV must be 3 ", Toast.LENGTH_SHORT).show();
            //stopping the execution further

        }

        if(cvv.length() == 3)
        {
            Toast.makeText(this, "payment successfully ", Toast.LENGTH_SHORT).show();
            //stopping the execution further
            finish();
            startActivity(new Intent(this,navigation.class));

        }



    }



    public void Register(View view)
    {
      registerUser();
    }
}
