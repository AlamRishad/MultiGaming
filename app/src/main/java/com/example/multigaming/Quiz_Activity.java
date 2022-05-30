package com.example.multigaming;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Quiz_Activity extends AppCompatActivity implements View.OnClickListener {

        Button btn1, btn2, btn3, btn4 ,restart , exitquiz;
        TextView question,question_attempted , score;
        int i = 0 , j = 0 , k = 0 , l = 0 ;

        private Quiz quest = new Quiz();
        private String answer;
        private int questionLength = quest.quest.length;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.quiz_activity);


            btn1 = (Button)findViewById(R.id.btn_one);
            btn1.setOnClickListener(this);
            btn2 = (Button)findViewById(R.id.btn_two);
            btn2.setOnClickListener(this);
            btn3 = (Button)findViewById(R.id.btn_three);
            btn3.setOnClickListener(this);
            btn4 = (Button)findViewById(R.id.btn_four);
            btn4.setOnClickListener(this);
            question_attempted = findViewById(R.id.question_attempted);
            restart = findViewById(R.id.btn_restart);
            exitquiz = findViewById(R.id.btn_endquiz);
            score = findViewById(R.id.score);
            restart = findViewById(R.id.btn_restart);

            question = (TextView)findViewById(R.id.question);

            Next(i);

            exitquiz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                 reset();
                }
            });
            restart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    newgame();
                }
            });
        }

    public void onClick(View v) {
            i++;
        question_attempted.setText("Question Attempted : "+i+"/5");

        if(v.getId()==R.id.btn_one){

            if(btn1.getText() == answer){
                j++;
                btn1.setBackgroundColor(getResources().getColor(R.color.green));
                l=1;
            }
            k=1;
        }
        else if(v.getId()==R.id.btn_two){

            if(btn2.getText() == answer){
                j++;
                l=2;
                btn2.setBackgroundColor(getResources().getColor(R.color.green));
            }
            k=2;
        }
        else if(v.getId()==R.id.btn_three){

            if(btn3.getText() == answer){
                j++;
                l=3;
                btn3.setBackgroundColor(getResources().getColor(R.color.green));
            }
            k=3;
        }
        else if(v.getId()==R.id.btn_four){

            if(btn4.getText() == answer){
                j++;
                l=4;
                btn4.setBackgroundColor(getResources().getColor(R.color.green));
            }
            k=4;
        }
        btn1.setClickable(false);
        btn2.setClickable(false);
        btn3.setClickable(false);
        btn4.setClickable(false);
        if(k!=l){
            if(k==1)btn1.setBackgroundColor(getResources().getColor(R.color.red));
            else if(k==2)btn2.setBackgroundColor(getResources().getColor(R.color.red));
            else if(k==3)btn3.setBackgroundColor(getResources().getColor(R.color.red));
            else if(k==4)btn4.setBackgroundColor(getResources().getColor(R.color.red));
            if(btn1.getText() == answer)btn1.setBackgroundColor(getResources().getColor(R.color.green));
            else  if(btn2.getText() == answer)btn2.setBackgroundColor(getResources().getColor(R.color.green));
            else  if(btn3.getText() == answer)btn3.setBackgroundColor(getResources().getColor(R.color.green));
            else  if(btn4.getText() == answer)btn4.setBackgroundColor(getResources().getColor(R.color.green));

        }
        score.setText("Current Score : "+j);

        if(i==5){
            i=0;
            score.setText("Quiz Finished !!! Your Scored "+j+" out of 5");
            j=0;
            restart.setVisibility(View.VISIBLE);
            exitquiz.setVisibility(View.VISIBLE);
            btn1.setClickable(false);
            btn2.setClickable(false);
            btn3.setClickable(false);
            btn4.setClickable(false);

        }
        else{
            l=0;
            score.setText("Current Score : "+j);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    Next(i);
                    btn1.setBackgroundColor(getResources().getColor(R.color.purple_500));
                    btn2.setBackgroundColor(getResources().getColor(R.color.purple_500));
                    btn3.setBackgroundColor(getResources().getColor(R.color.purple_500));
                    btn4.setBackgroundColor(getResources().getColor(R.color.purple_500));
                    btn1.setClickable(true);
                    btn2.setClickable(true);
                    btn3.setClickable(true);
                    btn4.setClickable(true);
                }
            }, 2000);
        }
    }

    private void reset(){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Quiz_Activity.this);
            alertDialogBuilder
                    .setMessage("Do you really want to quit ?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            alertDialogBuilder.show();

        }
    private void newgame(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Quiz_Activity.this);
        alertDialogBuilder
                .setMessage("Wanna play this quiz again ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), Quiz_Activity.class));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialogBuilder.show();

    }


    private void Next(int num){
            question.setText(quest.getQuestion(num));
            btn1.setText(quest.optionA(num));
            btn2.setText(quest.optionB(num));
            btn3.setText(quest.optionC(num));
            btn4.setText(quest.optionD(num));
            answer = quest.getAnswer(num);
        }

    }

