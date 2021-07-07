package com.abc.saloncom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MyMessage";

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonSignin;
    private TextView textViewSignup;
    private Button button;
    private ProgressBar progressBar;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null){
            //profile Activity here
            finish();
            startActivity(new Intent(getApplicationContext(), navigation.class));
        }


        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        buttonSignin = (Button) findViewById(R.id.buttonSignin);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        textViewSignup = (TextView) findViewById(R.id.textViewSignup);

        buttonSignin.setOnClickListener(this);
        textViewSignup.setOnClickListener(this);
    }

    private void userLogin(){

        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

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

        //if validation are ok
        //We will show a progressbar

        progressBar.setVisibility(View.VISIBLE);

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()){
                            finish();
                            //startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                            startActivity(new Intent(getApplicationContext(), navigation.class));
                        }
                        else {
                            Toast.makeText(LoginActivity.this,"Please Enter valid password or email",Toast.LENGTH_SHORT).show();

                        }

                    }
                });
    }
    @Override
    public void onClick(View v) {

        if (v==buttonSignin){
            userLogin();
        }

        if (v==textViewSignup){
            finish();
            startActivity(new Intent(this,MainActivity.class));
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
