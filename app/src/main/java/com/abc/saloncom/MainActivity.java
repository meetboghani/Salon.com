package com.abc.saloncom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MyMessage";


    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextConfirmPassword, editTextUser;
    private Button buttonRegister;
    private TextView textViewSignin;
    private ProgressBar progressBar;

    private FirebaseAuth firebaseAuth;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null){
            //profile Activity here
            finish();
            startActivity(new Intent(getApplicationContext(), navigation.class));
        }



        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextConfirmPassword = (EditText) findViewById(R.id.editTextConfirmPassword);
        editTextUser = (EditText) findViewById(R.id.editTextUser);

        textViewSignin = (TextView) findViewById(R.id.textViewSignin);

        databaseReference = FirebaseDatabase.getInstance().getReference("user");

        buttonRegister.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);
    }


    private void registerUser()
    {

        final String email = editTextEmail.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();
        String confirmpassword = editTextConfirmPassword.getText().toString().trim();
        final String username = editTextUser.getText().toString().trim();

        if (TextUtils.isEmpty(username)){

            //email is empty
            Toast.makeText(this,"Please enter Username",Toast.LENGTH_SHORT).show();
            //stopping the Execution further
            return;
        }

        if (TextUtils.isEmpty(email)){

            //email is empty
            Toast.makeText(this,"Please enter Email",Toast.LENGTH_SHORT).show();
            //stopping the Execution further
            return;
        }


        if (TextUtils.isEmpty(password)){

            //Password is empty
            Toast.makeText(this,"Please enter password",Toast.LENGTH_SHORT).show();
            //stopping the execution further
            return;
        }

        if (TextUtils.isEmpty(confirmpassword)){

            //Password is empty
            Toast.makeText(this,"Please enter  Confirm password",Toast.LENGTH_SHORT).show();
            //stopping the execution further
            return;
        }
        if(password.length()<6){

            Toast.makeText(this,"Length of the Password must be 6 ",Toast.LENGTH_SHORT).show();
            //stopping the execution further
            return;
        }

        //if validation are ok
        //We will show a progressbar

        progressBar.setVisibility(View.VISIBLE);
        if(password.equals(confirmpassword)) {

            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            progressBar.setVisibility(View.GONE);
                            if (task.isSuccessful()) {

                                User info = new User(username,email,password);

                                FirebaseDatabase.getInstance().getReference("user")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(info).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {

                                        Toast.makeText(MainActivity.this, "Sign Up Successfully", Toast.LENGTH_SHORT).show();

                                        finish();
                                        startActivity(new Intent(MainActivity.this, navigation.class));

                                    }
                                });


                            } else {
                                Toast.makeText(MainActivity.this, "Email already registered ", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
        }
    }
    @Override
    public void onClick(View v) {

        if (v==buttonRegister){

            registerUser();
        }

        if (v==textViewSignin){

            //will open login activity
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.i(TAG,"onStart");
    }



    @Override
    protected void onResume()
    {
        super.onResume();
        Log.i(TAG,"onResume");
    }


    @Override
    protected void onPause()
    {
        super.onPause();
        Log.i(TAG,"onPause");
    }


    @Override
    protected void onStop()
    {
        super.onStop();
        Log.i(TAG,"onStop");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.i(TAG,"onRestart");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.i(TAG,"onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        Log.i(TAG,"onSaveInstatceState");
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG,"onRestoreInstanceState");
    }
}

