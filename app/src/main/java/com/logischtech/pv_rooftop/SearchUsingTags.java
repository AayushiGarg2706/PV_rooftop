package com.logischtech.pv_rooftop;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.logischtech.pv_rooftop.Models.Search;
import com.logischtech.pv_rooftop.Models.Tags_Post_list;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class SearchUsingTags extends AppCompatActivity {

    private Activity usersActivity;
    EditText ed_search ;
    ImageView search1  ;
    Typeface tf ;
    String txt_search ;

    Button tag1 , tag2 , tag3 , tag4 , tag5, tag6 , tag7 , tag8 , tag9 , tag10 , tag11 , tag12 , tag13 , tag14 , tag15 , tag16 , tag17 , tag18, tag19 , tag20 ,tag21, tag22 , tag23 , tag24 , tag25, tag26 , tag27 , tag28 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_using_tags);
        ed_search =(EditText)findViewById(R.id.ev_search1);
        search1 = (ImageView)findViewById(R.id.search1);

        ed_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                    txt_search = ed_search.getText().toString() ;

                    Intent i = new Intent(SearchUsingTags.this , ListofPost_keyword.class);
                    i.putExtra("txt_search" ,txt_search);

                    startActivity(i);

                    return true;
                }
                return false;
            }
        });

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        search1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_search = ((EditText)findViewById(R.id.ev_search1)
                ).getText().toString();

                Intent i = new Intent(SearchUsingTags.this , ListofPost_keyword.class);
                i.putExtra("txt_search" ,txt_search);
                startActivity(i);

            }
        });
        ed_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   ev_search.setFocusableInTouchMode(true);
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

            }
        });





        tag1 = (Button)findViewById(R.id.tag1);
        tag2 = (Button)findViewById(R.id.tag2);
        tag3 = (Button)findViewById(R.id.tag3);
        tag4 = (Button)findViewById(R.id.tag4);
        tag5 = (Button)findViewById(R.id.tag5);
        tag6 = (Button)findViewById(R.id.tag6);
        tag7 = (Button)findViewById(R.id.tag7);
        tag8 = (Button)findViewById(R.id.tag8);
        tag9 = (Button)findViewById(R.id.tag9);
        tag10 = (Button)findViewById(R.id.tag10);
        tag11 = (Button)findViewById(R.id.tag11);
        tag12 = (Button)findViewById(R.id.tag12);
        tag13 = (Button)findViewById(R.id.tag13);
        tag14 = (Button)findViewById(R.id.tag14);
        tag15 = (Button)findViewById(R.id.tag15);

        tag16 = (Button)findViewById(R.id.tag16);
        tag17 = (Button)findViewById(R.id.tag17);
        tag18 = (Button)findViewById(R.id.tag18);
        tag19 = (Button)findViewById(R.id.tag19);
        tag20 = (Button)findViewById(R.id.tag20);
        tag21 = (Button)findViewById(R.id.tag21);
        tag22 = (Button)findViewById(R.id.tag22);
        tag23 = (Button)findViewById(R.id.tag23);
        tag24 = (Button)findViewById(R.id.tag24);
        tag25 = (Button)findViewById(R.id.tag25);
        tag26 = (Button)findViewById(R.id.tag26);
        tag27 = (Button)findViewById(R.id.tag27);


        TextView tv_tags = (TextView)findViewById(R.id.tv_tags);
        tf = Typeface.createFromAsset(getAssets(), "Montserrat/Montserrat-Bold.ttf");
        tv_tags.setTypeface(tf);



        usersActivity = this ;
//        tag27 = (Button)findViewById(R.id.tag27);
//        tag28 = (Button)findViewById(R.id.tag28);
        //https://faqs.solar/wp-json/wp/v2/posts?tags=5893
        tag1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                  //  //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                  //  tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));
                   // tag1.setTextColor(Color.parseColor("#ffffff"));

                   String tag_id = "645905133" ;

                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name" , "India");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);


                    //  String tag_id = tag1.getText().toString() ;
//645905130, 645905133, 5893, 645905210, 645905224, 277313, 45212 india

                }
                return false;
            }
        });

        tag2.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                    //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                   // tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));

                    String tag_id = "45212" ;
                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name", "Solar");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);



                    //  String tag_id = tag1.getText().toString() ;
//645905130, 645905133, 5893, 645905210, 645905224, 277313, 45212 india

                }
                return false;
            }
        });
        tag3.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                    //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    // tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));
                    // tag1.setTextColor(Color.parseColor("#ffffff"));

                    String tag_id = "277313" ;
                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name" , "Rooftop");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);

                    //  String tag_id = tag1.getText().toString() ;
//645905130, 645905133, 5893, 645905210, 645905224, 277313, 45212 india

                }
                return false;
            }
        });
        tag4.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                    //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    // tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));

                    String tag_id = "645905228" ;

                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name" , "Activites");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);


                    //  String tag_id = tag1.getText().toString() ;
//645905130, 645905133, 5893, 645905210, 645905224, 277313, 45212 india

                }
                return false;
            }
        });
        tag5.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                    //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    // tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));tag1.setTextColor(Color.parseColor("#ffffff"));

                    String tag_id = "645905129" ;

                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name" , "Technology");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);


                    //  String tag_id = tag1.getText().toString() ;
//645905130, 645905133, 5893, 645905210, 645905224, 277313, 45212 india

                }
                return false;
            }
        });



        tag6.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                    //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                   // tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));
                  //  tag1.setTextColor(Color.parseColor("#ffffff"));

                    String tag_id = "645905224" ;
                    //  String tag_id = tag1.getText().toString() ;

                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name" , "Plant");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);
//645905130, 645905133, 5893, 645905210, 645905224, 277313, 45212 india

                }
                return false;
            }
        });
        tag7.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                    //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    // tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));
                    // tag1.setTextColor(Color.parseColor("#ffffff"));

                    String tag_id = "174729" ;

                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name" , "Inverter");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);


                    //  String tag_id = tag1.getText().toString() ;
//645905130, 645905133, 5893, 645905210, 645905224, 277313, 45212 india

                }
                return false;
            }
        });

        tag8.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                    //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    // tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));

                    String tag_id = "645905130" ;

                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name" , "General Customer ");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);


                    //  String tag_id = tag1.getText().toString() ;
//645905130, 645905133, 5893, 645905210, 645905224, 277313, 45212 india

                }
                return false;
            }
        });

        tag9.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                    //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    //   tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));

                    String tag_id = "645905153" ;

                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name" , "GED");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);


                    //  String tag_id = tag1.getText().toString() ;
//645905130, 645905133, 5893, 645905210, 645905224, 277313, 45212 india

                }
                return false;
            }
        });


        tag11.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                    //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                  //  tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));

                    String tag_id = "645905210" ;

                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name" , "Operation");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);


                    //  String tag_id = tag1.getText().toString() ;
//645905130, 645905133, 5893, 645905210, 645905224, 277313, 45212 india

                }
                return false;
            }
        });
        //645905129

 //645905130
        tag10.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                    //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                   // tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));

                    String tag_id = "645905132" ;

                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name" , "Global ");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);


                    //  String tag_id = tag1.getText().toString() ;
//645905130, 645905133, 5893, 645905210, 645905224, 277313, 45212 india

                }
                return false;
            }
        });


        // portal
        tag12.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                    //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                  //  tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));

                    String tag_id = "645905154" ;

                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name" , "GEDA");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);


                    //  String tag_id = tag1.getText().toString() ;
//645905130, 645905133, 5893, 645905210, 645905224, 277313, 45212 india

                }
                return false;
            }
        });




        tag13.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                    //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                 //   tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));

                    String tag_id = "5893" ;

                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name" , "Maintenance");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);


                    //  String tag_id = tag1.getText().toString() ;
//645905130, 645905133, 5893, 645905210, 645905224, 277313, 45212 india

                }
                return false;
            }
        });

        tag14.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                    //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    // tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));

                    String tag_id = "645905220" ;

                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name" , "Process");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);


                    //  String tag_id = tag1.getText().toString() ;
//645905130, 645905133, 5893, 645905210, 645905224, 277313, 45212 india

                }
                return false;
            }
        });

        tag15.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                    //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    // tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));

                    String tag_id = "645905219" ;

                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name" , "Flow");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);


                    //  String tag_id = tag1.getText().toString() ;
//645905130, 645905133, 5893, 645905210, 645905224, 277313, 45212 india

                }
                return false;
            }
        });

        tag16.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                    //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    // tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));

                    String tag_id = "645905222" ;

                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name" , "Clearance");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);


                    //  String tag_id = tag1.getText().toString() ;
//645905130, 645905133, 5893, 645905210, 645905224, 277313, 45212 india

                }
                return false;
            }
        });
        tag17.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                    //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    // tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));

                    String tag_id = "645905135" ;

                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name" , "Goa");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);


                    //  String tag_id = tag1.getText().toString() ;
//645905130, 645905133, 5893, 645905210, 645905224, 277313, 45212 india

                }
                return false;
            }
        });
        tag18.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                    //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    // tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));

                    String tag_id = "645905223" ;

                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name" , "Portal");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);
                }
                return false;
            }
        });

        tag19.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                    //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    // tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));

                    String tag_id = "645905214" ;

                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name" , "Process Flow");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);
                }
                return false;
            }
        });

        tag20.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                    //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    // tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));

                    String tag_id = "645905216" ;

                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name" , "SWCP");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);
                }
                return false;
            }
        });
        tag21.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                    //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    // tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));

                    String tag_id = "645905220" ;

                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name" , "Single");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);
                }
                return false;
            }
        });
        tag22.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                    //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    // tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));

                    String tag_id = "59701148" ;

                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name" , "Gross Metering");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);
                }
                return false;
            }
        });
        tag23.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                    //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    // tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));

                    String tag_id = "919467" ;

                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name" , "Net Metering");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);
                }
                return false;
            }
        });
        tag24.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                    //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    // tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));

                    String tag_id = "17801923" ;

                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name" , "MPPT");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);
                }
                return false;
            }
        });

        tag25.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                    //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    // tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));

                    String tag_id = "645905231" ;

                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name" , "Dispute");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);
                }
                return false;
            }
        });
        tag26.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                    //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    // tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));

                    String tag_id = "166866" ;

                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name" , "Contract");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);
                }
                return false;
            }
        });
        tag27.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){


                    //Button Pressed
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    // tag1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_orange));

                    String tag_id = "645905230" ;

                    Intent i = new Intent(SearchUsingTags.this , Tags_Post_list.class);
                    i.putExtra("tag_name" , "Owner");
                    i.putExtra("tag_id", tag_id);
                    startActivity(i);
                }
                return false;
            }
        });




    }

}
