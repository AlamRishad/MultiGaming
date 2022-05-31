package com.example.multigaming;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {
    private Button dot, doublezero,AC,percent,bracket,divide,one,two,three,four,five,six,seven,eight,nine,zero,plus,minus,multiple,equal,CE,back;
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        AC=findViewById(R.id.AC);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        zero=findViewById(R.id.zero);
        doublezero=findViewById(R.id.doublezero);
        multiple=findViewById(R.id.multiple);
        divide=findViewById(R.id.divide);
        plus=findViewById(R.id.plus);
        minus=findViewById(R.id.minus);
        percent=findViewById(R.id.percent);
        textview=findViewById(R.id.textview);
        CE=findViewById(R.id.CE);
        dot=findViewById(R.id.dot);
        equal=findViewById(R.id.equal);
        back=findViewById(R.id.back);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( CalculatorActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        //-----------AC-----------------
        AC.setOnClickListener(new View.OnClickListener(){
                                  public void onClick(View v) {
                                      textview.setText("0");
                                  }
                              }
        );
        //-------------------------------
        //--------------CE---------------
        CE.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String s = (String) textview.getText();
                if(s.equals("Math Error") || s.length()==1) {
                    textview.setText("0");
                }

                else{
                    String s1="";
                    for(int i = 0 ; i < s.length()-1;i++){
                        s1=s1+s.charAt(i);
                    }
                    textview.setText(s1);
                }
            }                              }
        );
        //--------------------------------
        //-------------1------------------
        one.setOnClickListener(new View.OnClickListener(){
                                   public void onClick(View v) {
                                       String s = (String) textview.getText();
                                       if(s.equals("Math Error") || s.equals("0") ) {
                                           textview.setText("1");
                                       }
                                       else{
                                           s=s+'1';
                                           textview.setText(s);
                                       }
                                   }
                               }
        );
        //--------------------------------
        //-------------2------------------
        two.setOnClickListener(new View.OnClickListener(){
                                   public void onClick(View v) {
                                       String s = (String) textview.getText();
                                       if(s.equals("Math Error") || s.equals("0")) {
                                           textview.setText("2");
                                       }
                                       else{
                                           s=s+'2';
                                           textview.setText(s);
                                       }
                                   }
                               }
        );
        //--------------------------------
        //-------------3------------------
        three.setOnClickListener(new View.OnClickListener(){
                                     public void onClick(View v) {
                                         String s = (String) textview.getText();
                                         if(s.equals("Math Error") || s.equals("0")) {
                                             textview.setText("3");
                                         }
                                         else{
                                             s=s+'3';
                                             textview.setText(s);
                                         }
                                     }
                                 }
        );
        //--------------------------------
        //-------------4------------------
        four.setOnClickListener(new View.OnClickListener(){
                                    public void onClick(View v) {
                                        String s = (String) textview.getText();
                                        if(s.equals("Math Error") || s.equals("0")) {
                                            textview.setText("4");
                                        }
                                        else{
                                            s=s+'4';
                                            textview.setText(s);
                                        }
                                    }
                                }
        );
        //--------------------------------
        //-------------5------------------
        five.setOnClickListener(new View.OnClickListener(){
                                    public void onClick(View v) {
                                        String s = (String) textview.getText();
                                        if(s.equals("Math Error") || s.equals("0")) {
                                            textview.setText("5");
                                        }
                                        else{
                                            s=s+'5';
                                            textview.setText(s);
                                        }
                                    }
                                }
        );
        //--------------------------------
        //-------------6------------------
        six.setOnClickListener(new View.OnClickListener(){
                                   public void onClick(View v) {
                                       String s = (String) textview.getText();
                                       if(s.equals("Math Error") || s.equals("0")) {
                                           textview.setText("6");
                                       }
                                       else{
                                           s=s+'6';
                                           textview.setText(s);
                                       }
                                   }
                               }
        );
        //--------------------------------
        //-------------7------------------
        seven.setOnClickListener(new View.OnClickListener(){
                                     public void onClick(View v) {
                                         String s = (String) textview.getText();
                                         if(s.equals("Math Error") || s.equals("0")) {
                                             textview.setText("7");
                                         }
                                         else{
                                             s=s+'7';
                                             textview.setText(s);
                                         }
                                     }
                                 }
        );
        //--------------------------------
        //-------------8------------------
        eight.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String s = (String) textview.getText();
                if(s.equals("Math Error") || s.equals("0")) {
                    textview.setText("8");
                }
                else{
                    s=s+'8';
                    textview.setText(s);
                }
            }                              }
        );
        //--------------------------------
        //-------------9------------------
        nine.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String s = (String) textview.getText();
                if(s.equals("Math Error") || s.equals("0")) {
                    textview.setText("9");
                }
                else{
                    s=s+'9';
                    textview.setText(s);
                }
            }                              }
        );
        //--------------------------------
        //-------------0------------------
        zero.setOnClickListener(new View.OnClickListener(){
                                    public void onClick(View v) {
                                        String s = (String) textview.getText();
                                        if(s.equals("Math Error") || s.equals("0")) {
                                            textview.setText("0");
                                        }
                                        else{
                                            s=s+'0';
                                            textview.setText(s);
                                        }
                                    }
                                }
        );
        //-----------------------------------
        //-------------plus------------------
        plus.setOnClickListener(new View.OnClickListener(){
                                    public void onClick(View v) {
                                        String s = (String) textview.getText();

                                        s=s+ '+';
                                        textview.setText(s);
                                    }
                                }
        );
        //------------------------------------
        //-------------minus------------------
        minus.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String s = (String) textview.getText();
                s=s+'-';
                textview.setText(s);
            }                               }
        );
        //-----------------------------------
        //-------------multiple------------------
        multiple.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String s = (String) textview.getText();
                s=s+'X';
                textview.setText(s);

            }                               }
        );
        //-----------------------------------
        //-------------divide------------------
        divide.setOnClickListener(new View.OnClickListener(){
                                      public void onClick(View v) {
                                          String s = (String) textview.getText();
                                          s=s+'/';
                                          textview.setText(s);
                                      }
                                  }
        );
        //-----------------------------------
        //-------------equal------------------
        equal.setOnClickListener(new View.OnClickListener(){
                                     public void onClick(View v) {
                                         String s = (String) textview.getText();
                                         double ans = 0 ;
                                         int count=0;
                                         String[] s2 = new String[1000];
                                         String[] s4 = new String[1000];

                                         for(int i = 0 ; i<s.length();i++) {
                                             String s1 = "";
                                             String s3 = "";
                                             while (true) {
                                                 if (s.charAt(i) == '+' || s.charAt(i) == '/' || s.charAt(i) == 'X' || s.charAt(i) == '-') {
                                                     if (s.length() >= i) {
                                                         s3 = s3 + s.charAt(i);

                                                     }
                                                     break;
                                                 } else {
                                                     s1 = s1 + s.charAt(i);
                                                 }
                                                 i++;
                                                 if (i == s.length()){

                                                     break;

                                                 }
                                             }

                                             s2[count] = s1;
                                             s4[count] = s3;
                                             Log.d("tata",s2[count]);
                                             Log.d("tat",s4[count]);
                                             count++;
                                         }
                                         int flag1= 0;
                                         try {
                                             int b = s2[0].length();
                                             b--;
                                             String s5 = "";
                                             s5 = s5 + s2[0].charAt(b);
                                             Log.d("t",s5);

                                             if(s5.equals("%")){
                                                 String s1 =  "";
                                                 for(int j = 0 ; j < b;j++){

                                                     s1=s1+s2[0].charAt(j);
                                                 }
                                                 Log.d("ta",s1);
                                                 ans = Double.parseDouble(s1);
                                                 ans =  ans / 100;
                                                 Log.d("ta",ans+"as");
                                             }
                                             else {
                                                 ans = Double.parseDouble(s2[0]);
                                             }
                                         }catch (Exception e){
                                             flag1=1;
                                         }

                                         int flag=0;
                                         if(flag1==0){
                                             for(int i = 0 ; i < count;i++) {
                                                 if (s4[i].equals("")) break;

//                    else {
                                                 double a;
                                                 try {
                                                     int b = s2[i+1].length();
                                                     b--;
                                                     String s5 = "";
                                                     s5 = s5 + s2[i+1].charAt(b);
                                                     Log.d("t",s5);

                                                     if(s5.equals("%")){
                                                         String s1 =  "";
                                                         for(int j = 0 ; j < b;j++){

                                                             s1=s1+s2[i+1].charAt(j);
                                                         }
                                                         Log.d("ta",s1);
                                                         a = Double.parseDouble(s1);
                                                         a =  a / 100;
                                                         Log.d("ta",a+"as");
                                                     }
                                                     else {
                                                         a = Double.parseDouble(s2[i + 1]);
                                                     }
                                                 }catch (Exception e){
                                                     flag1=1;
                                                     Log.d("ta","as");
                                                     break;
                                                 }
                                                 if (s4[i].equals("+")) {
                                                     ans = ans + a;
                                                 } else if (s4[i].equals("-")) {
                                                     ans = ans - a;
                                                 } else if (s4[i].equals("/")) {
                                                     if (a != 0) {
                                                         ans = ans / a;
                                                     } else {
                                                         flag = 1;
                                                     }
                                                 } else if (s4[i].equals("X")) {
                                                     if (count == 1) {
                                                         ans = 1 * a;
                                                     } else
                                                         ans = ans * a;
                                                 } else {
                                                     ans = ans;
                                                 }

                                             }
                                         }
                                         s = ans + "";
                                         if(flag==1 || flag1==1)
                                             textview.setText("Math Error");
                                         else
                                             textview.setText(s);
                                     }
                                 }
        );
        //--------------------------------
        //-------------0------------------
        doublezero.setOnClickListener(new View.OnClickListener(){
                                          public void onClick(View v) {
                                              String s = (String) textview.getText();
                                              if(s.equals("0")) {
                                                  textview.setText("00");
                                              }
                                              else{
                                                  s=s+'0';
                                                  s=s+'0';
                                                  textview.setText(s);
                                              }
                                          }
                                      }
        );
        //----------------------------------
        //-------------dot------------------
        dot.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String s = (String) textview.getText();

                char s2 = s.charAt(s.length()-1);
                if(s.equals("0")) {
                    textview.setText(".");
                }
                else{
                    int count = 0 , flag = 0;
                    String s1 = "";
                    s=s+".";
                    for(int i = 0 ; i < s.length();i++){
                        if(s.charAt(i)=='+' || s.charAt(i)=='/' || s.charAt(i)=='X' || s.charAt(i)=='-' ){
                            count=0;
                        }
                        else if(s.charAt(i)=='.'){
                            count++;
                        }
                        if(count==2){
                            flag=1;
                        }
                    }
                    if(flag==0) {
                        textview.setText(s);
                    }
                    else{
                        for(int i = 0 ; i < s.length()-1;i++){
                            s1=s1+s.charAt(i);
                        }
                        textview.setText(s1);
                    }


                }
            }                               }
        );
        //--------------------------------------
        //-------------percent------------------
        percent.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String s = (String) textview.getText();

                char s2 = s.charAt(s.length()-1);
                if(s.equals("0")) {
                    textview.setText("0%");
                }
                else if(s2=='+' || s2=='/' || s2=='X' || s2=='-'){
                    String s1="";
                    for(int i = 0 ; i < s.length()-1;i++){

                        s1=s1+s.charAt(i);
                    }
                    s1=s1+'%';
                    s=s1;
                    textview.setText(s1);
                }
                else{
                    s=s+'%';
                    textview.setText(s);
                }
            }                               }
        );






    }
}
