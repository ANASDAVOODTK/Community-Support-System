package com.live.clg_project;

import android.app.Application;

import net.igenius.mqttservice.MQTTService;

public class Initializer extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        MQTTService.NAMESPACE = "192.168.25.32"; //or BuildConfig.APPLICATION_ID;
        MQTTService.KEEP_ALIVE_INTERVAL = 60; //in seconds
        MQTTService.CONNECT_TIMEOUT = 30; //in seconds
    }
}