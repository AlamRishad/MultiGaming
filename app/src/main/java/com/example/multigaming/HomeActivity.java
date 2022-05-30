package com.example.multigaming;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;

public class HomeActivity extends Fragment {
    Activity context;
    Button  exit;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        context = getActivity();
        View root =  inflater.inflate(R.layout.activity_home, container, false);
        return root;
    }
    public void onStart(){
        super.onStart();

        Button play = (Button) context.findViewById(R.id.play);
        Button play2 = (Button) context.findViewById(R.id.exit);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( context,Quiz_Activity.class);
                startActivity(intent);
            }
        });
        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( context,TikTakTokActivity.class);
                startActivity(intent);
            }
        });
    }
}
