package com.logischtech.pv_rooftop;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class PV_technology extends AppCompatActivity {
    TextView faqs_for , welcome_p1 , welcome_p2 , welcome_p3 , welcome_p4 , faq1 , faq_1,faq_2 , faq_a1 , faq_a2  ,welcome_p5 ,welcome_p6  ;
    Typeface tf ,tf1 , tf2 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pv_technology);
        final EditText ev_search = (EditText) findViewById(R.id.ev_search);

        faqs_for = (TextView)findViewById(R.id.faqs_for);
        welcome_p1 = (TextView)findViewById(R.id.welcome_p1);
        welcome_p2 = (TextView)findViewById(R.id.welcome_p2);
        welcome_p3 = (TextView)findViewById(R.id.welcome_p3);
        welcome_p4 = (TextView)findViewById(R.id.welcome_p4);
        welcome_p5 = (TextView)findViewById(R.id.welcome_p5);
        welcome_p6 = (TextView)findViewById(R.id.welcome_p6);

        faq1 = (TextView)findViewById(R.id.faq1);
        tf =Typeface.createFromAsset(getAssets() ,"Montserrat/Montserrat-Bold.ttf");
        tf1 = Typeface.createFromAsset(getAssets() , "Montserrat/Montserrat-SemiBold.ttf");
        tf2 = Typeface.createFromAsset(getAssets() , "Montserrat/Montserrat-Medium.ttf");
        welcome_p1.setTypeface(tf1);
        welcome_p2.setTypeface(tf1);
        welcome_p3.setTypeface(tf1);
        welcome_p4.setTypeface(tf1);
        welcome_p5.setTypeface(tf1);
        welcome_p6.setTypeface(tf1);
        faqs_for.setTypeface(tf1);
        faq1.setTypeface(tf);


        ev_search.setFocusable(false);

        ev_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ev_search.setFocusableInTouchMode(true);
            }
        });
    }
}
