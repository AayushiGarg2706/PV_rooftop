package com.logischtech.pv_rooftop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.drm.DrmStore;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class Profile_4 extends AppCompatActivity {

    RadioGroup rg ;
    TextView l1,l2,l3, q1  , a1,a2,a3 ,a4;
    Typeface tf ,tf1 ;
    SharedPreferences sharedPreferences ;
    Boolean fourthtime ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_4);
        sharedPreferences = getSharedPreferences("MyPref" , MODE_PRIVATE );
        fourthtime =  sharedPreferences.getBoolean("fourthtime" ,true);

        if(fourthtime)
        {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            fourthtime = false ;
            editor.putBoolean("fourthtime" ,fourthtime);
            editor.apply();
        }
        else
        {
            Intent i = new Intent(Profile_4.this , Welcome.class);
            startActivity(i);
            finish();
        }



        rg = (RadioGroup)findViewById(R.id.questions);
        l1 = (TextView)findViewById(R.id.l1);
        l2 = (TextView)findViewById(R.id.l2);
        l3 = (TextView)findViewById(R.id.l3);
        q1 = (TextView)findViewById(R.id.p4q1);
        a1 = (TextView)findViewById(R.id.p4a1);
        a2 = (TextView)findViewById(R.id.p4a2);
        a3 = (TextView)findViewById(R.id.p4a3);
        tf =Typeface.createFromAsset(getAssets() ,"Montserrat/Montserrat-Bold.ttf");
        tf1 = Typeface.createFromAsset(getAssets() , "Montserrat/Montserrat-SemiBold.ttf");



        l1.setTypeface(tf);
        l2.setTypeface(tf);
        l3.setTypeface(tf);
        q1.setTypeface(tf);
        a1.setTypeface(tf1);
        a2.setTypeface(tf1);
        a3.setTypeface(tf1);



        Button next = (Button)findViewById(R.id.next4);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (rg.getCheckedRadioButtonId() == -1) {

                    //  iv.setEnabled(false);
                } else {

                    Intent i = new Intent(Profile_4.this, Welcome.class);
                    startActivity(i);
                }
            }
        });

            }
}
