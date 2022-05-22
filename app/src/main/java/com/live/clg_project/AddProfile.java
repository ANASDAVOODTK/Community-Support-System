package com.live.clg_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.live.clg_project.Model.UserData1;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AddProfile extends AppCompatActivity {

    ImageView imgBack;
    TextInputEditText txtName,txtAge,txtMobile,txtHouseName,txtHouseNumber,txtDesignation,txtWard,txtAddress;
    MaterialButton btnaddMember;
    LottieAnimationView animationView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profile);

        imgBack = findViewById(R.id.imgBack);
        txtName = findViewById(R.id.txtfname);
        txtAge = findViewById(R.id.txtAge);
        txtMobile = findViewById(R.id.txtPhone);
        txtHouseName = findViewById(R.id.txtHouseName);
        txtHouseNumber = findViewById(R.id.txtHouseNumber);
        txtDesignation = findViewById(R.id.txtDesignation);
        txtWard = findViewById(R.id.txtWard);
        txtAddress = findViewById(R.id.txtAddress);
        btnaddMember = findViewById(R.id.addMember);
        animationView = findViewById(R.id.anim);

        SharedPreferences pref = getSharedPreferences("Name", Context.MODE_PRIVATE);
        String isAdded = pref.getString("InitialProfile","");



        if(!isAdded.equals("1"))
        {
            String phone = pref.getString("Mobile","");
            String name = pref.getString("Name","");
            txtName.setText(name);
            txtMobile.setText(phone);

        }
        else
        {
            String Hn = pref.getString("HouseNumber","");
            String wd = pref.getString("Ward","");
            txtHouseNumber.setText(Hn);
            txtWard.setText(wd);
            txtHouseNumber.setEnabled(false);
            txtWard.setEnabled(false);

        }

        onBackPressed();
        btnaddMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animationView.setVisibility(View.VISIBLE);
                addMember();
            }
        });

    }

    public void addMember()
    {
        String userId= FirebaseAuth.getInstance().getCurrentUser().getUid();
        String name = txtName.getText().toString();
        String age = txtAge.getText().toString();
        String mobile = txtMobile.getText().toString();
        String HouseName = txtHouseName.getText().toString();
        String HouseNumber = txtHouseNumber.getText().toString();
        String Designation = txtDesignation.getText().toString();
        String Ward = txtWard.getText().toString();
        String Address = txtAddress.getText().toString();
        if(name.isEmpty()|| age.isEmpty()||mobile.isEmpty()||HouseName.isEmpty()||HouseNumber.isEmpty()||Designation.isEmpty()||Ward.isEmpty() ||Address.isEmpty())
        {
            Toast.makeText(this, "Please Enter All Details", Toast.LENGTH_SHORT).show();
        }
        else
        {

            Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
            UserData1 model = new UserData1(userId,name,mobile,age,HouseName,HouseNumber,Ward,Address,Designation);
            Call<UserData1> call = methods.postUserdata(model);
            call.enqueue(new Callback<UserData1>() {
                @Override
                public void onResponse(Call<UserData1> call, Response<UserData1> response) {
                    animationView.setVisibility(View.GONE);

                    SharedPreferences pref = getSharedPreferences("Name", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("InitialProfile","1");
                    editor.putString("HouseNumber",HouseNumber);
                    editor.putString("Ward",Ward);
                    editor.apply();

                    Toast.makeText(AddProfile.this, "Successfully Added", Toast.LENGTH_SHORT).show();
                    Intent intent;
                    intent = new Intent(AddProfile.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onFailure(Call<UserData1> call, Throwable t) {

                }
            });
        }
    }

    public void onBackPressed()
    {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddProfile.this, ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}