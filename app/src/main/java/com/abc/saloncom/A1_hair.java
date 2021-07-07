package com.abc.saloncom;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class A1_hair extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    public static String final_cat;
    private Button button;
    ArrayList<String> selection = new ArrayList<>();
    public static  final String Extra_text = "haircutting.Extra_text";
    //CheckBox ch1;


    //public static  final String Extra_text1 = "facial.Extra_text1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1_hair);
        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        button = (Button) findViewById(R.id.button10);
        //ch1 = (CheckBox) findViewById(R.id.check1)
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openbooking();
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {


        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void selectcat(View view) {

        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {

            case R.id.check1:
                if (checked) {
                    selection.add("Hair cutting         150/-");
                } else {
                    selection.remove("Hair cutting         150/-");

                }
                break;

            case R.id.check2:
                if (checked) {
                    selection.add("Facial                   250/-");
                } else {
                    selection.remove("Facial                   250/-");

                }
                break;

        }
    }



    public void openbooking() {

        String final_cat = "";
        // CheckBox checkbox1 = (CheckBox) findViewById(R.id.check1);

        //if ()
        for (String Selections : selection) {
            final_cat = final_cat + Selections + "\n\n";//checkbox1.getText().toString();
            ///CheckBox checkbox2 = (CheckBox) findViewById(R.id.check2);
            // String final_sel = //checkbox2.getText().toString();
        }


        Intent intent = new Intent(this, booking.class);
        intent.putExtra(Extra_text,final_cat);
        //intent.putExtra(Extra_text1,final_sel);

        startActivity(intent);

    }


    public void register1(View view)
    {


    }


}

