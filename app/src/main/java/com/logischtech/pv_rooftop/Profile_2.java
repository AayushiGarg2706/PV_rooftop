package com.logischtech.pv_rooftop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Profile_2 extends AppCompatActivity {
    RadioGroup rg ;
    TextView l1 , l2,l3 , q1  , a1,a2,a3 ,a4 , a5,a6,a7,a8 , a9;
    Typeface tf ,tf1 ;
    SharedPreferences sharedPreferences ;
    Boolean secondtime ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_2);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        sharedPreferences = getSharedPreferences("MyPref" , MODE_PRIVATE );
        secondtime =  sharedPreferences.getBoolean("secondtime" ,true);

        if(secondtime){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            secondtime = false ;
            editor.putBoolean("secondtime" ,secondtime);
            editor.apply();


//            Intent i = new Intent(Profile_1.this , Profile_2.class);
//            startActivity(i);

        }
        else {
            Intent i = new Intent(Profile_2.this , profile_3.class);
            startActivity(i);
            finish();


        }


        rg = (RadioGroup)findViewById(R.id.questions);
        l1 = (TextView)findViewById(R.id.l1);
        l2 = (TextView)findViewById(R.id.l2);
        l3 = (TextView)findViewById(R.id.l3);
        q1 = (TextView)findViewById(R.id.p2q1);
        a1 = (TextView)findViewById(R.id.p2a1);
        a2 = (TextView)findViewById(R.id.p2a2);
        a3 = (TextView)findViewById(R.id.p2a3);
        a4 = (TextView)findViewById(R.id.p2a4);
        a5 = (TextView)findViewById(R.id.p2a5);
        a6 = (TextView)findViewById(R.id.p2a6);
        a7 = (TextView)findViewById(R.id.p2a7);
        a8 = (TextView)findViewById(R.id.p2a8);
        a9 = (TextView)findViewById(R.id.p2a9);

        tf =Typeface.createFromAsset(getAssets() ,"Montserrat/Montserrat-Bold.ttf");
        tf1 = Typeface.createFromAsset(getAssets() , "Montserrat/Montserrat-SemiBold.ttf");



        l1.setTypeface(tf);
        l2.setTypeface(tf);
        l3.setTypeface(tf);
        q1.setTypeface(tf);
        a1.setTypeface(tf1);
        a2.setTypeface(tf1);
        a3.setTypeface(tf1);
        a4.setTypeface(tf1);
        a5.setTypeface(tf1);
        a6.setTypeface(tf1);
        a7.setTypeface(tf1);
        a8.setTypeface(tf1);
        a9.setTypeface(tf1);




//


        Button iv = (Button)findViewById(R.id.next2);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(rg.getCheckedRadioButtonId() == -1)
                {

                    //  iv.setEnabled(false);
                }
                else {

                    Intent i = new Intent(Profile_2.this ,profile_3.class);
                    startActivity(i);
                }

            }
        });
    }
}
