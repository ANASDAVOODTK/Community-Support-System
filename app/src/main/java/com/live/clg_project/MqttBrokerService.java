package com.live.clg_project;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.StrictMode;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import io.moquette.BrokerConstants;
import io.moquette.server.config.MemoryConfig;

public class MqttBrokerService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        io.moquette.server.Server server = new io.moquette.server.Server();
        try {
            String root = getFilesDir().getAbsolutePath()+ File.separator + BrokerConstants.DEFAULT_MOQUETTE_STORE_MAP_DB_FILENAME;
            File file = new File(root);
            if(file.exists()){
                file.delete();
            }

            MemoryConfig memoryConfig = new MemoryConfig(new Properties());//.getAbsolutePath()
            memoryConfig.setProperty(BrokerConstants.PERSISTENT_STORE_PROPERTY_NAME, getFilesDir().getAbsolutePath()+ File.separator + BrokerConstants.DEFAULT_MOQUETTE_STORE_MAP_DB_FILENAME);

            server.startServer(memoryConfig);
            Toast.makeText(MqttBrokerService.this, "Server Started", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
