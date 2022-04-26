package com.live.clg_project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;


@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    private static final long delayTime = 1500;
    Handler handler = new Handler();
    private Context context;
    String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Intent serviceIntent = new Intent(this,MqttBrokerService.class);
        startService(serviceIntent);
        try
        {
            userId= FirebaseAuth.getInstance().getCurrentUser().getUid();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        handler.postDelayed(postTask, delayTime);

       this.context = SplashActivity.this;
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacks(postTask);
        super.onDestroy();
    }

    Runnable postTask = new Runnable() {
        @Override
        public void run() {


            if(userId==null||userId.isEmpty())
            {
                Intent intent;
                intent = new Intent(SplashActivity.this, PhoneAuth0.class);
                startActivity(intent);
                finish();
            }
            else
            {
                Intent intent;
                intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

        }
    };


}