
package com.logischtech.pv_rooftop;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import com.logischtech.pv_rooftop.Models.Author;
import com.logischtech.pv_rooftop.Models.Tags;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Tag_Post_Detail extends AppCompatActivity {
    String tags_list ;
    String formatted_date ;
    Date date1 ;
    Typeface tf , tf1 , tf2 ;
    TextView tv_title , tv_content , tv_date , tv_author , tv_tags ;
    String a_id  ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag__post__detail);
        final Intent startingIntent = getIntent();

        String title1 = startingIntent.getStringExtra("title");
        String author = startingIntent.getStringExtra("author");
        String  tags = startingIntent.getStringExtra("tags").replace("[" ,"") ;

        tags_list = tags.replace("]" , "");
        //  String date1 = startingIntent.getStringExtra("date").replace("T" , " ");
        String answer = startingIntent.getStringExtra("content");
        SimpleDateFormat parseDateFormat = new SimpleDateFormat("yyyy-mm-dd"); // if your match.getDate() given this format date.and if is given different format that time define that format.
        try {
            String date = startingIntent.getStringExtra("date").replace("T" , " ");
                formatted_date = DateFormat.getDateInstance().format(date).toString();


            date1=parseDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        String tags_name11 = tags_name10.replaceAll("645905133" , "India")    ;
        tf = Typeface.createFromAsset(getAssets(), "Montserrat/Montserrat-Bold.ttf");
        tf1 = Typeface.createFromAsset(getAssets(), "Montserrat/Montserrat-SemiBold.ttf");
        tf2 = Typeface.createFromAsset(getAssets(), "Montserrat/Montserrat-Medium.ttf");

        String  sub  = "&#038;" ;
        String otherStr = "&" ;

        String title_rs = title1.replace(sub, otherStr);

        tv_author = (TextView)findViewById(R.id.faq_author);
        tv_content = (TextView)findViewById(R.id.faq_content);
        tv_date = (TextView)findViewById(R.id.faq_date);
        tv_tags = (TextView)findViewById(R.id.faq_tags);
        tv_title = (TextView)findViewById(R.id.faq_title);
        tv_title.setText(title_rs);
        tv_date.setText( formatted_date);

//        tv_tags.setText(tags_list);
        tv_content.setText(Html.fromHtml(answer));
        tv_title.setTypeface(tf);
        tv_content.setTypeface(tf2);
        tv_author.setTypeface(tf2);
        tv_tags.setTypeface(tf2);
        tv_tags.setTypeface(tf2);


        a_id = author.toString();
        new HttpgetAuthorName().execute(a_id);










    }

    private class HttpgetAuthorName extends AsyncTask<Object, Object , Author> {
        private ProgressDialog progress = new ProgressDialog(Tag_Post_Detail.this);

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
        private ProgressDialog progress = new ProgressDialog(Tag_Post_Detail.this);

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
