package com.live.clg_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.live.clg_project.Model.NotificationData;
    public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder>{
        private NotificationData[] listdata;

        public NotificationAdapter(NotificationData[] listdata) {
            this.listdata = listdata;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View listItem= layoutInflater.inflate(R.layout.notification_item, parent, false);
            ViewHolder viewHolder = new ViewHolder(listItem);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.textNoti.setText(listdata[position].getText());

        }


        @Override
        public int getItemCount() {
            return listdata.length;
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public TextInputEditText textNoti;
            public ViewHolder(View itemView) {
                super(itemView);
                this.textNoti = (TextInputEditText) itemView.findViewById(R.id.textNotification);
            }
        }
}