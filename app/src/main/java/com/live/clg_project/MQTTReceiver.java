package com.live.clg_project;

import android.content.Context;
import android.util.Log;

import net.igenius.mqttservice.MQTTServiceReceiver;

public class MQTTReceiver extends MQTTServiceReceiver {

    @Override
    public void onPublishSuccessful(Context context, String requestId,
                                    String topic) {
        // called when a message has been successfully published
        Log.e("TAG", "Subscribed to " + topic);
    }

    @Override
    public void onSubscriptionSuccessful(Context context, String requestId,
                                         String topic) {
        // called when a subscription is successful
    }

    @Override
    public void onSubscriptionError(Context context, String requestId,
                                    String topic, Exception exception) {
        // called when a subscription is not successful.
        // This usually happens when the broker does not give permissions
        // for the requested topic
    }

    @Override
    public void onMessageArrived(Context context, String topic,
                                 byte[] payload) {
        // called when a new message arrives on any topic
        Log.e("TAG", "New message on " + topic + ":  " + new String(payload));
    }

    @Override
    public void onConnectionSuccessful(Context context, String requestId) {
        // called when the connection is successful
    }

    @Override
    public void onException(Context context, String requestId,
                            Exception exception) {
        // called when an error happens
    }

    @Override
    public void onConnectionStatus(Context context, boolean connected) {
        // called when connection status is requested or changes
    }
}
