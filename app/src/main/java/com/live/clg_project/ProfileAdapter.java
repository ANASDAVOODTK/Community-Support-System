package com.live.clg_project;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.live.clg_project.Model.UsersData;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {
    private ArrayList<UsersData.data> android;

    public ProfileAdapter(ArrayList<UsersData.data> android) {
        this.android = android;
    }

    @Override
    public ProfileAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.profile_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProfileAdapter.ViewHolder viewHolder, int i) {

        viewHolder.pname.setText("Name : "+android.get(i).getName());
        viewHolder.pphome.setText("Phone : "+android.get(i).getPhone());
        viewHolder.page.setText("Age : "+android.get(i).getAge());


        if (android.get(i).getDesignation().equals("Owner"))
        {
         viewHolder.btnOwner.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView pname,pphome,page,member;
        public MaterialButton btnOwner;
        public ViewHolder(View view) {
            super(view);

            pname = (TextView)view.findViewById(R.id.pname);
            member = (TextView)view.findViewById(R.id.member);
            pphome = (TextView)view.findViewById(R.id.pphone);
            page = (TextView)view.findViewById(R.id.page);
            btnOwner = (MaterialButton)view.findViewById(R.id.materialButton);

        }
    }

}
