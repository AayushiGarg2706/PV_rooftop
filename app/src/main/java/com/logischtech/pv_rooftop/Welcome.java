package com.logischtech.pv_rooftop;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.logischtech.pv_rooftop.Models.Search;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class Welcome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ScrollView sc;
    LinearLayout faq;
    ImageView mb;
    ListView listView ;
    TextView faqs_for, welcome_p1, welcome_p2, welcome_p3, welcome_p4, faq1, faq_1, faq_2, faq_a1, faq_a2;
    Typeface tf, tf1, tf2;
    private Activity usersActivity;
    private   String   txt_search ;
//    EditText ev_search1 ;
    TextView faqs_for2 ;
     EditText ev_search ;

    LinearLayout tab1, tab2 , main , main1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
//        getWindow().setSoftInputMode(
//                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        sc = (ScrollView) findViewById(R.id.scroll_lower);
        faq = (LinearLayout) findViewById(R.id.faq);

        final DrawerLayout dr = (DrawerLayout) findViewById(R.id.dr);
        tab1 = (LinearLayout) findViewById(R.id.tab1);
        tab2 = (LinearLayout) findViewById(R.id.tab2);

       // ev_search1 = (EditText)findViewById(R.id.ev_search1) ;


        main = (LinearLayout)findViewById(R.id.main);
        usersActivity = this ;


        ImageView search = (ImageView) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_search = ((EditText) findViewById(R.id.ev_search)).getText().toString();

                Intent i = new Intent(Welcome.this , ListofPost_keyword.class);
                i.putExtra("txt_search" ,txt_search);
                startActivity(i);



            }
        });
       // txt_search = ((EditText) findViewById(R.id.ev_search)).getText().toString();

        ev_search = (EditText)findViewById(R.id.ev_search) ;


        ev_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                    txt_search = ev_search.getText().toString() ;



                    Intent i = new Intent(Welcome.this , ListofPost_keyword.class);
                    i.putExtra("txt_search" ,txt_search);

                    startActivity(i);

                    return true;
                }
                return false;
            }
        });


        faqs_for = (TextView) findViewById(R.id.faqs_for);


        welcome_p1 = (TextView) findViewById(R.id.welcome_p1);
        welcome_p2 = (TextView) findViewById(R.id.welcome_p2);
        welcome_p3 = (TextView) findViewById(R.id.welcome_p3);
        welcome_p4 = (TextView) findViewById(R.id.welcome_p4);
        faq_1 = (TextView) findViewById(R.id.faq_1);
        faq_2 = (TextView) findViewById(R.id.faq_2);
        faq_a1 = (TextView) findViewById(R.id.faq_a1);
        faq_a2 = (TextView) findViewById(R.id.faq_a2);
        TextView faq_3 = (TextView) findViewById(R.id.faq_3);
        TextView faq_a3 = (TextView) findViewById(R.id.faq_a3);

        faq1 = (TextView) findViewById(R.id.faq1);
        tf = Typeface.createFromAsset(getAssets(), "Montserrat/Montserrat-Bold.ttf");
        tf1 = Typeface.createFromAsset(getAssets(), "Montserrat/Montserrat-SemiBold.ttf");
        tf2 = Typeface.createFromAsset(getAssets(), "Montserrat/Montserrat-Medium.ttf");
        //tf2 = Typeface.createFromAsset(getAssets() , "Montserrat/Montserrat-Medium.ttf");


        welcome_p1.setTypeface(tf1);
        welcome_p2.setTypeface(tf1);
        welcome_p3.setTypeface(tf1);
        welcome_p4.setTypeface(tf1);
        faqs_for.setTypeface(tf1);
        faq1.setTypeface(tf);
        faq_1.setTypeface(tf1);
        faq_2.setTypeface(tf1);
        faq_a1.setTypeface(tf2);
        faq_a2.setTypeface(tf2);
        faq_3.setTypeface(tf1);
        faq_a3.setTypeface(tf2);


         ev_search = (EditText) findViewById(R.id.ev_search);
      //  ev_search.setFocusable(false);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
      //  ev_search.setFocusableInTouchMode(true);

        ev_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   ev_search.setFocusableInTouchMode(true);
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

            }
        });


        mb = (ImageView) findViewById(R.id.mb);

        mb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dr.openDrawer(GravityCompat.START);


            }
        });
        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Welcome.this, PV_technology.class);
                startActivity(i);

            }
        });
        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ib = new Intent(Welcome.this, Benefits.class);
                startActivity(ib);

            }
        });


//        sc.setVisibility(View.GONE);
//        faq.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        sc.setVisibility(View.VISIBLE);
//                    }
//                });

        setNavigationViewListner();


    }

    private void setNavigationViewListner() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_drawer);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.signout:
                Intent i = new Intent(Welcome.this, Splash.class);
                startActivity(i);

                break;





            case R.id.cif_form:
                Intent ic = new Intent(Welcome.this, CIF_Delhi_form.class);
                startActivity(ic);

                break;



        }




        return false;

    }


}