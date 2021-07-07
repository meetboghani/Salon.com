package com.abc.saloncom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Relief extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ArrayList<String> selection = new ArrayList<>();
    private Button button;
    public static String final_cat2;
    public static final String Extra_text2 = "haircutting.Extra_text2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relief);
        Spinner spinner = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openbooking1();
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

    public void selectcat2(View view) {

        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {

            case R.id.check5:
                if (checked) {
                    selection.add("Hair cutting         150/-");
                } else {
                    selection.remove("Hair cutting         150/-");

                }
                break;

            case R.id.check6:
                if (checked) {
                    selection.add("Facial                   250/-");
                } else {
                    selection.remove("Facial                   250/-");

                }
                break;

        }
    }

    private void openbooking1() {
        String final_cat2 = "";
        // CheckBox checkbox1 = (CheckBox) findViewById(R.id.check1);
        for (String Selections : selection) {
            final_cat2 = final_cat2 + Selections + "\n\n";//checkbox1.getText().toString();
            ///CheckBox checkbox2 = (CheckBox) findViewById(R.id.check2);
            // String final_sel = //checkbox2.getText().toString();
            }
            Intent intent = new Intent(this, booking1.class);
            intent.putExtra(Extra_text2, final_cat2);
            //intent.putExtra(Extra_text1,final_sel);

            startActivity(intent);


        }

}
