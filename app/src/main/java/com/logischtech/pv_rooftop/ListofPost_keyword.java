package com.logischtech.pv_rooftop;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.logischtech.pv_rooftop.Models.Search;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class ListofPost_keyword extends AppCompatActivity {
    Activity usersActivity ;
    ImageView floating ;
    TextView faqs_for2 ;
    Typeface tf ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listof_post_keyword);
        final Intent startingIntent = getIntent();
        String txt_search = startingIntent.getStringExtra("txt_search");
        usersActivity =this ;
        faqs_for2= (TextView)findViewById(R.id.faqs_for2) ;
        floating = (ImageView)findViewById(R.id.floating);
        faqs_for2.setText(txt_search);
        tf = Typeface.createFromAsset(getAssets(), "Montserrat/Montserrat-Bold.ttf");


        faqs_for2.setTypeface(tf);



        floating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent  i = new Intent(ListofPost_keyword.this , SearchUsingTags.class);
                startActivity(i);

            }
        });


        new Httpsearch().execute(txt_search);

    }
    private class Httpsearch extends AsyncTask<String, String, Search[]> {
        private ProgressDialog progress = new ProgressDialog(ListofPost_keyword.this);


        @Override
        protected Search[] doInBackground(String... params) {

            try {
                String txt_search = params[0];
                String url = "https://faqs.solar/wp-json/wp/v2/posts?search=" + txt_search;
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.setErrorHandler(new CustomResponseErrorHandler());
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Search[] search_api = restTemplate.getForObject(url, Search[].class);
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
//            progress.setCancelable(true);
//            progress.setOnCancelListener(new DialogInterface.OnCancelListener() {
//                @Override
//                public void onCancel(DialogInterface dlg) {
//                    HttpRequestTask.this.cancel(true);
//                }
//            });


            this.progress.show();
        }

        ViewPager viewPager;

        @Override
        protected void onPostExecute(final Search[] exam) {

            super.onPostExecute(exam);

            if (progress.isShowing()) {
                progress.dismiss();
            }







//            for (int i = 0 ;i <= exam.length ;i++)
//            {
//                String rs = exam[i].getExcerpt().getRendered() ;
//
//
//                String an = exam[i].getTitle() .getRendered() ;
//
//                Intent in = new Intent(Welcome.this, Faq_list.class);
//                in.putExtra("MY_kEY",rs);
//                in.putExtra("MY_key1", an) ;
//                startActivity(in);
//
//
//            }
          ListView  listView =(ListView)findViewById(R.id.list);
            Utility.setListViewHeightBasedOnChildren(listView);
            UsersAdapter adapter=new UsersAdapter(usersActivity, exam ,getApplicationContext());
            listView.setAdapter(adapter);


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                    int  h = parent.getPositionForView(view)  ;


                    String title = exam[h].getTitle().getRendered().toString() ;
                    String content = exam[h].getContent().getRendered().toString();
                    String author  = exam[h].getAuthor().toString() ;



                    String  tags = exam[h].getTags().toString();




                    String date = exam[h].getDate().toString();
                    Intent sendStuff = new Intent(ListofPost_keyword.this, Faqs_detail.class);
                    sendStuff.putExtra("title", title);
                    sendStuff.putExtra("content" , content);
                    sendStuff.putExtra("author" , author);
                    sendStuff.putExtra("tags" , tags);
                    sendStuff.putExtra("date" , date);

                    startActivity(sendStuff);







                }

            });







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
    }

}
