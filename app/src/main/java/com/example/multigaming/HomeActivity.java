package com.example.multigaming;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeActivity extends Fragment {
    Activity context;
    Button  exit;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ArrayList<ElementModel> element;
    myadapter adapter;
    private myadapter.RecycleViewClickListener listener;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        context = getActivity();
        View root =  inflater.inflate(R.layout.activity_home, container, false);
        recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        element = new ArrayList<>();
        element.add(new ElementModel(R.drawable.image1));
        element.add(new ElementModel(R.drawable.image2));
        element.add(new ElementModel(R.drawable.image11));
        element.add(new ElementModel(R.drawable.image12));
//
//        initData();
//        initRecycleview();
        setOnClickListener();
        recyclerView.setAdapter(new myadapter(element, listener));
        return root;
    }

    private void setOnClickListener() {
        listener = new myadapter.RecycleViewClickListener() {
            @Override
            public void onclick(View v, int position) {
                if(position==0){
                    Intent intent = new Intent( context,Quiz_Activity.class);
                    startActivity(intent);
                }
                else if(position==1){
                    Intent intent = new Intent( context,TikTakTokActivity.class);
                    startActivity(intent);
                }
                else if(position==2){
                    Intent intent = new Intent( context,CalculatorActivity.class);
                    startActivity(intent);
                }
                else if(position==3){
                    Intent intent = new Intent( context,SettingActivity.class);
                    startActivity(intent);
                }
            }
        };
    }

//    private void initData() {
//    }
//
//    private void initRecycleview() {
//        recyclerView = findViewById(R.id.recycler_view);
//        layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(RecyclerView.VERTICAL);
//        recyclerView.setLayoutManager(layoutManager);
//        adapter =new ItemAdapter(HomeActivity.this , element);
//        recyclerView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
//
//    }
}
