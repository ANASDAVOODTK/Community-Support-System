package com.live.clg_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.live.clg_project.Model.LocalBodyModel;
import com.live.clg_project.Model.UsersData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocalBodyActivity extends AppCompatActivity {

    TextView house,male,female,children,adult,aged;
    LottieAnimationView animationView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_body);
        house = findViewById(R.id.house);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        children = findViewById(R.id.children);
        adult = findViewById(R.id.adult);
        aged = findViewById(R.id.aged);
        animationView = findViewById(R.id.anim);
        gerData();
    }

    public void gerData()
    {


        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        Call<LocalBodyModel> call = methods.getLocalBody();
        call.enqueue(new Callback<LocalBodyModel>() {
            @Override
            public void onResponse(Call<LocalBodyModel> call, Response<LocalBodyModel> response) {

                Log.d("tttttttttttt","code:  "+response.code());
                animationView.setVisibility(View.GONE);

                ArrayList<LocalBodyModel.data> data = response.body().getData();
                for(LocalBodyModel.data data1: data)
                {

                    house.setText(data1.getHouses());
                    male.setText(data1.getMales());
                    female.setText(data1.getFemales());
                    children.setText(data1.getChildren());
                    adult.setText(data1.getAdults());
                    aged.setText(data1.getAged());

                }


            }

            @Override
            public void onFailure(Call<LocalBodyModel> call, Throwable t) {

            }
        });
    }
}