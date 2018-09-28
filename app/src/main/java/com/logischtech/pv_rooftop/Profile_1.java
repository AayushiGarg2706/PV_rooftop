package com.logischtech.pv_rooftop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Profile_1 extends AppCompatActivity {
    RadioGroup rg ;

    TextView l1 , l2,l3 , q1  , a1,a2,a3 ,a4;
    Typeface tf ,tf1 ;
    SharedPreferences sharedPreferences ;
    Boolean firsttime ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile1);
      final   Button iv = (Button) findViewById(R.id.next);
        rg = (RadioGroup)findViewById(R.id.questions);
        l1 = (TextView)findViewById(R.id.l1);
        l2 = (TextView)findViewById(R.id.l2);
        l3 = (TextView)findViewById(R.id.l3);
        q1 = (TextView)findViewById(R.id.q1);
        a1 = (TextView)findViewById(R.id.a1);
        a2 = (TextView)findViewById(R.id.a2);
        a3 = (TextView)findViewById(R.id.a3);
        a4 = (TextView)findViewById(R.id.a4);
//       if (Build.VERSION.SDK_INT >= 21) {
//            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }

        sharedPreferences = getSharedPreferences("MyPref" , MODE_PRIVATE );
       firsttime =  sharedPreferences.getBoolean("firsttime" ,true);

        if(firsttime){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            firsttime = false ;
            editor.putBoolean("firsttime" ,firsttime);
            editor.apply();


//            Intent i = new Intent(Profile_1.this , Profile_2.class);
//            startActivity(i);

        }
        else {
            Intent i = new Intent(Profile_1.this , Profile_2.class);
            startActivity(i);
            finish();


        }


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

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(rg.getCheckedRadioButtonId() == -1)
                {

                  //  iv.setEnabled(false);
                }
                else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    firsttime = false ;
                    editor.putBoolean("firsttime" ,firsttime);


                    Intent i = new Intent(Profile_1.this , Profile_2.class);
                    startActivity(i);


                }
                          }
        });




    }

    private void setWindowFlag(Profile_1 profile_1, int flagTranslucentStatus, boolean b) {
        Window win = profile_1.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (b) {
            winParams.flags |= flagTranslucentStatus;
        } else {
            winParams.flags &= ~flagTranslucentStatus;
        }
        win.setAttributes(winParams);



    }
}
