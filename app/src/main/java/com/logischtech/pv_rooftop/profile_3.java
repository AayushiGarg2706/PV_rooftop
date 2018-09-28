package com.logischtech.pv_rooftop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import static com.logischtech.pv_rooftop.R.id.tag_ind;

public class profile_3 extends AppCompatActivity {

    CardView  tag_arg,tag_aus ,tag_nz , tag_ind ;
    TextView tv1, tv2 ,tv3 , tv4 ;
    ImageView   ar_arg ,ar_aus , ar_nz , ar_ind ;
    Button next ;
    RadioGroup rg ;
    LinearLayout content ;
    TextView l1 , l2,l3 , q1  , a1,a2,a3 ,a4;
    Typeface tf ,tf1 ;
    TextView city1 , city2,city3  ;
    SharedPreferences sharedPreferences ;
    Boolean thirdtime ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_3);

        sharedPreferences = getSharedPreferences("MyPref" , MODE_PRIVATE );
        thirdtime =  sharedPreferences.getBoolean("thirdtime" ,true);

        if(thirdtime){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            thirdtime = false ;
            editor.putBoolean("thirdtime" ,thirdtime);
            editor.apply();


//            Intent i = new Intent(Profile_1.this , Profile_2.class);
//            startActivity(i);

        }
        else {
            Intent i = new Intent(profile_3.this , Profile_4.class);
            startActivity(i);
            finish();


        }

        tag_ind  = (CardView) findViewById(R.id.tag_ind);
        tag_arg = (CardView) findViewById(R.id.tag_arg);
        tag_aus = (CardView) findViewById(R.id.tag_aus);
        tag_nz = (CardView) findViewById(R.id.tag_nz);
        ar_arg = (ImageView) findViewById(R.id.arrow_arg);
        rg = (RadioGroup)findViewById(R.id.questions);
        content = (LinearLayout)findViewById(R.id.content);
        content.setVisibility(View.INVISIBLE);
        l1 = (TextView)findViewById(R.id.l1);
        l2 = (TextView)findViewById(R.id.l2);
        l3 = (TextView)findViewById(R.id.l3);
        q1 = (TextView)findViewById(R.id.p3q1);
        tf =Typeface.createFromAsset(getAssets() ,"Montserrat/Montserrat-Bold.ttf");
        tf1 = Typeface.createFromAsset(getAssets() , "Montserrat/Montserrat-SemiBold.ttf");



        l1.setTypeface(tf);
        l2.setTypeface(tf);
        l3.setTypeface(tf);
        q1.setTypeface(tf);




        ar_ind = (ImageView) findViewById(R.id.arrow_ind);
        ar_aus = (ImageView) findViewById(R.id.arrow_aus);
        ar_nz = (ImageView) findViewById(R.id.arrow_nz);
        ar_ind.setVisibility(View.GONE);
      //  tag_ind.performClick();
      //  tag_ind.setPressed(true);
        ar_aus.setVisibility(View.GONE);
        ar_arg.setVisibility(View.GONE);
         city1 = (TextView)findViewById(R.id.city1);
         city2 = (TextView)findViewById(R.id.city2);
         city3 = (TextView)findViewById(R.id.city3);
        city1.setTypeface(tf1);
        city2.setTypeface(tf1);
        city3.setTypeface(tf1);


        //india














        //



        ar_nz.setVisibility(View.GONE);
        next  = (Button)findViewById(R.id.next3);


        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);
        tv4 = (TextView)findViewById(R.id.tv4);

        tv1.setTypeface(tf1);
        tv2.setTypeface(tf1);
        tv3.setTypeface(tf1);
        tv4.setTypeface(tf1);


//india default click
        tag_ind.setBackgroundColor(Color.parseColor("#F78F1E"));
        ar_ind.setVisibility(View.VISIBLE);
        ar_aus.setVisibility(View.GONE);
        ar_nz.setVisibility(View.GONE);
        city1.setText("Delhi");
        city2.setText("Goa");
        city3.setText("Kerala");
        content.setVisibility(View.VISIBLE);


        tag_arg.setBackgroundColor(Color.parseColor("#FFFFFF"));
        tag_aus.setBackgroundColor(Color.parseColor("#FFFFFF"));
        tag_nz.setBackgroundColor(Color.parseColor("#FFFFFF"));


        ar_arg.setVisibility(View.GONE);

        tv2.setTextColor(Color.parseColor("#0071C5"));
        tv3.setTextColor(Color.parseColor("#0071C5"));
        tv4.setTextColor(Color.parseColor("#0071C5"));


        tv1.setTextColor(Color.parseColor("#FFFFFF"));



//










        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rg.getCheckedRadioButtonId() == -1)
                {

                    //  iv.setEnabled(false);
                }
                else {


                    Intent i = new Intent(profile_3.this, Profile_4.class);
                    startActivity(i);
                }
            }
        });

        tag_ind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tag_ind.setBackgroundColor(Color.parseColor("#F78F1E"));
                ar_ind.setVisibility(View.VISIBLE);
                ar_aus.setVisibility(View.GONE);
                ar_nz.setVisibility(View.GONE);
                city1.setText("Delhi");
                city2.setText("Goa");
                city3.setText("Kerala");
                content.setVisibility(View.VISIBLE);


                tag_arg.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tag_aus.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tag_nz.setBackgroundColor(Color.parseColor("#FFFFFF"));


                ar_arg.setVisibility(View.GONE);

                tv2.setTextColor(Color.parseColor("#0071C5"));
                tv3.setTextColor(Color.parseColor("#0071C5"));
                tv4.setTextColor(Color.parseColor("#0071C5"));


                tv1.setTextColor(Color.parseColor("#FFFFFF"));

            }
        });






        tag_arg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tag_arg.setBackgroundColor(Color.parseColor("#F78F1E"));
                tv2.setTextColor(Color.parseColor("#FFFFFF"));
                tv1.setTextColor(Color.parseColor("#0071C5"));
                tv3.setTextColor(Color.parseColor("#0071C5"));
                tv4.setTextColor(Color.parseColor("#0071C5"));

                content.setVisibility(View.VISIBLE);

                ar_arg.setVisibility(View.VISIBLE);
                ar_ind.setVisibility(View.GONE);
                ar_aus.setVisibility(View.GONE);
                ar_nz.setVisibility(View.GONE);
                tag_aus.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tag_aus.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tag_nz.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tag_aus.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tag_ind.setBackgroundColor(Color.parseColor("#FFFFFF"));

                city1.setText("Buenos Aires");
                city2.setText("Córdoba");
                city3.setText("Rosario");




            }
        });



        tag_aus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tag_aus.setBackgroundColor(Color.parseColor("#F78F1E"));
                tag_nz.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tag_arg.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tag_ind.setBackgroundColor(Color.parseColor("#FFFFFF"));

                ar_aus.setVisibility(View.VISIBLE);

                ar_nz.setVisibility(View.GONE);
                  ar_ind.setVisibility(View.GONE);
                ar_arg.setVisibility(View.GONE);
                content.setVisibility(View.VISIBLE);

                city1.setText("Sydney ");
                city2.setText("Melbourne ");
                city3.setText("Brisbane ");


                tv2.setTextColor(Color.parseColor("#0071C5"));
                tv3.setTextColor(Color.parseColor("#FFFFFF"));
                tv4.setTextColor(Color.parseColor("#0071C5"));


                tv1.setTextColor(Color.parseColor("#0071C5"));

            }
        });
        tag_nz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tag_nz.setBackgroundColor(Color.parseColor("#F78F1E"));

                tag_aus.setBackgroundColor(Color.parseColor("#FFFFFF"));

                tag_arg.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tag_ind.setBackgroundColor(Color.parseColor("#FFFFFF"));


                ar_ind.setVisibility(View.GONE);
                ar_arg.setVisibility(View.GONE);
                ar_aus.setVisibility(View.GONE);
                content.setVisibility(View.VISIBLE);

                city1.setText("Auckland  ");
                city2.setText("Wellington  ");
                city3.setText("Christchurch  ");


                tv4.setTextColor(Color.parseColor("#FFFFFF"));
                tv2.setTextColor(Color.parseColor("#0071C5"));
                tv3.setTextColor(Color.parseColor("#0071C5"));

                tv1.setTextColor(Color.parseColor("#0071C5"));

                ar_nz.setVisibility(View.VISIBLE);
            }
        });





    }



    }

