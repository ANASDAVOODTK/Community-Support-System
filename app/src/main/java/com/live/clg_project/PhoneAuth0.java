package com.live.clg_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class PhoneAuth0 extends AppCompatActivity {
    ImageView imgBack,imgGo;
    TextInputEditText txtFullName,txtMobile;
    TextView textEmergency;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_auth0);
        imgBack = findViewById(R.id.imgBack);
        txtFullName = findViewById(R.id.txtFullName);
        txtMobile = findViewById(R.id.txtMobile);
        imgGo = findViewById(R.id.imgGo);
        textEmergency = findViewById(R.id.txtChangePhone);


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        imgGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName = Objects.requireNonNull(txtFullName.getText()).toString();
                String mobile = Objects.requireNonNull(txtMobile.getText()).toString();

                if(fullName.isEmpty())
                {
                    Toast.makeText(PhoneAuth0.this, "Please Enter Your Name", Toast.LENGTH_SHORT).show();
                }
                else if(mobile.isEmpty())
                {
                    Toast.makeText(PhoneAuth0.this, "Please Enter Your Mobile", Toast.LENGTH_SHORT).show();
                }
                else

                {

                    SharedPreferences pref = getSharedPreferences("Name", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("Mobile",mobile);
                    editor.putString("Name",fullName);
                    editor.apply();


                    Intent intent = new Intent(PhoneAuth0.this,PhoneAuth.class);
                    intent.putExtra("Mobile", mobile);
                    startActivity(intent);
                }

            }
        });

        txtMobile.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    String fullName = Objects.requireNonNull(txtFullName.getText()).toString();
                    String mobile = Objects.requireNonNull(txtMobile.getText()).toString();

                    if(fullName.isEmpty())
                    {
                        Toast.makeText(PhoneAuth0.this, "Please Enter Your Name", Toast.LENGTH_SHORT).show();
                    }
                    else if(mobile.isEmpty())
                    {
                        Toast.makeText(PhoneAuth0.this, "Please Enter Your Mobile", Toast.LENGTH_SHORT).show();
                    }
                    else

                    {

                        SharedPreferences pref = getSharedPreferences("Name", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("Mobile",mobile);
                        editor.putString("Name",fullName);
                        editor.apply();


                        Intent intent = new Intent(PhoneAuth0.this,PhoneAuth.class);
                        intent.putExtra("Mobile", mobile);
                        startActivity(intent);
                    }
                }
                return false;
            }
        });

        textEmergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhoneAuth0.this, EmergencyActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Exit From App")
                .setMessage("Are you sure you want to close this App?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }
}