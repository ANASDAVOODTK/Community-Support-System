package com.live.clg_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttMessage;


public class WasteBinActivity extends AppCompatActivity {
    MqttHelper mqttHelper;
    ImageView imgWasteBin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waste_bin);
        imgWasteBin = findViewById(R.id.imgWasteBin);


        try{
            new MqttHelper(getApplicationContext()).mqttAndroidClient.setCallback(
                    new MqttCallbackExtended() {
                        @Override
                        public void connectComplete(boolean b, String s) {
                            Toast.makeText(getApplicationContext(),
                                    "MQTT connect complete",
                                    Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void connectionLost(Throwable throwable) {
                            Toast.makeText(getApplicationContext(),
                                    "MQTT connection lost",
                                    Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {


                            int a  = Integer.parseInt(mqttMessage.toString());
                            double test= 100-(((double) a / 27)*100);
                            String wasteStatus = String.format("%.2f", test);
                            TextView textView = findViewById(R.id.txtWastePercentage);
                            textView.setText(wasteStatus+" %");

                            if(test<25)
                            {
                                imgWasteBin.setImageResource(R.drawable.ic_wastbin1);
                            }

                            if(test>25)
                            {
                                imgWasteBin.setImageResource(R.drawable.ic_wastbin2);
                            }
                            if(test>50)
                            {
                                imgWasteBin.setImageResource(R.drawable.ic_wastbin3);
                            }

                            if(test>75)
                            {
                                imgWasteBin.setImageResource(R.drawable.ic_wastbin4);
                            }


                        }

                        @Override
                        public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
                            Toast.makeText(getApplicationContext(),
                                    "MQTT delivery complete",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
            );
        } catch(Exception e){
            e.printStackTrace();
        }
    }



}