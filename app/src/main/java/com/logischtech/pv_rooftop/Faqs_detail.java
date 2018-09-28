package com.logischtech.pv_rooftop;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.logischtech.pv_rooftop.Models.Author;
import com.logischtech.pv_rooftop.Models.Search;
import com.logischtech.pv_rooftop.Models.Tags;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static android.R.attr.format;

public class Faqs_detail extends AppCompatActivity {
    TextView tv_title , tv_content , tv_date , tv_author , tv_tags ;
    String a_id  ;

    String tags_ids;
      String tag_id ;
    Typeface tf , tf1 , tf2 ;
    ImageView floating ;
    String tags_list ;
    Date date1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs_detail);
        final Intent startingIntent = getIntent();

        String title1 = startingIntent.getStringExtra("title");
        String author = startingIntent.getStringExtra("author");
        String  tags = startingIntent.getStringExtra("tags").replace("[" ,"") ;

         tags_list = tags.replace("]" , "");
      //  String date1 = startingIntent.getStringExtra("date").replace("T" , " ");
        String answer = startingIntent.getStringExtra("content");
        SimpleDateFormat parseDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:MM:ss"); // if your match.getDate() given this format date.and if is given different format that time define that format.
        DateFormat formatdate = new SimpleDateFormat(" dd MMM yyyy");
//645905228, 5893, 645905210, 645905224, 277313, 45212] activites
        try {
            String date = startingIntent.getStringExtra("date").replace("T" , " ");


             date1=parseDateFormat.parse(date);
           Log.d("New Date",formatdate.format(date1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        String tags_name11 = tags_name10.replaceAll("645905133" , "India")    ;
        tf = Typeface.createFromAsset(getAssets(), "Montserrat/Montserrat-Bold.ttf");
        tf1 = Typeface.createFromAsset(getAssets(), "Montserrat/Montserrat-SemiBold.ttf");
        tf2 = Typeface.createFromAsset(getAssets(), "Montserrat/Montserrat-Medium.ttf");














//        Scanner input = new Scanner(System.in);
//         String in = "&" ;
//        title1 = input.next();
//        if(title1.matches("[&#038;]")){
//            in = title1;
//        }


       // boolean isFound = title1.contains("&#038;");
        String  sub  = "&#038;" ;
        String otherStr = "&" ;

        String title_rs = title1.replace(sub, otherStr);

        // true


        tv_author = (TextView)findViewById(R.id.faq_author);
        tv_content = (TextView)findViewById(R.id.faq_content);
        tv_date = (TextView)findViewById(R.id.faq_date);
        tv_tags = (TextView)findViewById(R.id.faq_tags);
        tv_title = (TextView)findViewById(R.id.faq_title);
        tv_title.setText(title_rs);
//        tv_tags.setText(tags_list);
        String dateformat = date1.toString();
        tv_date.setText( dateformat);
        tv_content.setText(Html.fromHtml(answer));
        tv_title.setTypeface(tf);
        tv_content.setTypeface(tf2);
        tv_author.setTypeface(tf2);
        tv_tags.setTypeface(tf2);
        tv_tags.setTypeface(tf2);


        a_id = author.toString();
        new HttpgetAuthorName().execute(a_id);





    }

    private class HttpgetAuthorName extends AsyncTask<Object, Object, Author> {
        private ProgressDialog progress = new ProgressDialog(Faqs_detail.this);

        @Override
        protected Author doInBackground(Object... params) {
            try {

                a_id = (String) params[0];


                String url = "https://faqs.solar/wp-json/wp/v2/users/" + a_id;
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.setErrorHandler(new CustomResponseErrorHandler());
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Author search_api = restTemplate.getForObject(url, Author.class);
                return search_api;

            } catch (Exception e) {
                this.progress.setMessage("");

            }


            return null;
        }

        @Override
        protected void onPreExecute() {
            //   getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            this.progress.setMessage("Loading Results");


            this.progress.show();
        }

        ViewPager viewPager;

        @Override
        protected void onPostExecute(final Author authors) {

            super.onPostExecute(authors);

            if (progress.isShowing()) {
                progress.dismiss();
            }

              String a_name = authors.getName().toString() ;
            tv_author.setText(a_name);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    new HttpPostTag().execute(tags_list);

                }
            });


                }









        }

        private class CustomResponseErrorHandler implements ResponseErrorHandler {
            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse response) throws IOException {

            }
        }

    private class HttpPostTag extends AsyncTask<Object, Object, Tags[]> {
        private ProgressDialog progress = new ProgressDialog(Faqs_detail.this);

        @Override
        protected Tags[] doInBackground(Object... params) {
            try {




                tags_list = (String) params[0];

              //645905130, 645905208, 645905132, 174729, 645905129 technology

                String url = "https://faqs.solar/wp-json/wp/v2/tags?include=" + tags_list;
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.setErrorHandler(new CustomResponseErrorHandler());
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Tags[] tags = restTemplate.getForObject(url, Tags[].class);
                  return tags;

            } catch (Exception e) {
                this.progress.setMessage("");

            }


            return null;
        }

        @Override
        protected void onPreExecute() {
            //   getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            this.progress.setMessage("Loading Results");
//            progress.setCancelable(true);
//            progress.setOnCancelListener(new DialogInterface.OnCancelListener() {
//                @Override
//                public void onCancel(DialogInterface dlg) {
//                    HttpRequestTask.this.cancel(true);
//                }
//            });


            this.progress.show();
        }

        @Override
        protected void onPostExecute(final Tags[] tags) {

            super.onPostExecute(tags);

            if (progress.isShowing()) {
                progress.dismiss();
            }


            for(int i = 0;i <tags.length;i++){
                tv_tags.append(tags[i].getName().toString());

                tv_tags.append("\t");


            }




        }
    }}

