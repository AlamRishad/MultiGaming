package com.example.multigaming;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingActivity extends Activity {


    //Control
    private com.example.multigaming.AppConstants.Control m_Control;
    Button newGameButton;
    Button endGameButton;

    Boolean isSoundEnabled = true;
    public SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        preferences = getSharedPreferences("SnakePreferences", Context.MODE_PRIVATE);
        m_Control = com.example.multigaming.AppConstants.Control.DUAL;
        newGameButton = (Button) findViewById(R.id.newGameButton);
        endGameButton = (Button) findViewById(R.id.endGameButton);

        newGameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                newGameButtonClicked();
            }
        });
        endGameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                endGameButtonClicked();
            }
        });




        isSoundEnabled = preferences.getBoolean("IsSoundEnabled",true);


    }


    public void newGameButtonClicked()
    {
//        Intent myIntent = new Intent(CurrentActivity.this, NextActivity.class);
//        myIntent.putExtra("key", value); //Optional parameters
//        CurrentActivity.this.startActivity(myIntent);

        SharedPreferences.Editor editor = preferences.edit();
        editor.apply();

        Intent myIntent = new Intent(SettingActivity.this, SnakeActivity.class);
        myIntent.putExtra(com.example.multigaming.AppConstants.CONTROL_KEY,m_Control);
        SettingActivity.this.startActivity(myIntent);
    }

    public void endGameButtonClicked()
    {
//        Intent myIntent = new Intent(CurrentActivity.this, NextActivity.class);
//        myIntent.putExtra("key", value); //Optional parameters
//        CurrentActivity.this.startActivity(myIntent);

        Intent myIntent = new Intent(SettingActivity.this, MainActivity.class);

        startActivity(myIntent);
    }



    public void povControlRadioClicked()
    {
        m_Control = com.example.multigaming.AppConstants.Control.POV;
        }


    public void dualControlRadioClicked()
    {
        m_Control = com.example.multigaming.AppConstants.Control.DUAL;
        }
    //endregion


    //region Sound



    //endregion
}
