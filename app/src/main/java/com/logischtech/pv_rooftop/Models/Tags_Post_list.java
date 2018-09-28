package com.logischtech.pv_rooftop.Models;

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
import android.widget.ListView;
import android.widget.TextView;

import com.logischtech.pv_rooftop.Faqs_detail;
import com.logischtech.pv_rooftop.ListofPost_keyword;
import com.logischtech.pv_rooftop.R;
import com.logischtech.pv_rooftop.SearchUsingTags;
import com.logischtech.pv_rooftop.Tag_Post_Detail;
import com.logischtech.pv_rooftop.UsersAdapter;
import com.logischtech.pv_rooftop.Utility;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class Tags_Post_list extends AppCompatActivity {
    private Activity usersActivity;
    TextView tv_name ;
    Typeface tf ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tags__post_list);
        final Intent startingIntent = getIntent();
        String tag_name = startingIntent.getStringExtra("tag_name");
        TextView tv_anme = (TextView)findViewById(R.id.tag_name);
        tv_anme.setText(tag_name);
        tf = Typeface.createFromAsset(getAssets(), "Montserrat/Montserrat-Bold.ttf");
        tv_anme.setTypeface(tf);


        String tag_id = startingIntent.getStringExtra("tag_id");
        usersActivity = this ;

        new HttpTagsPostList().execute(tag_id);




    }
    private class HttpTagsPostList extends AsyncTask<String , String , Search[]> {
        private ProgressDialog progress = new ProgressDialog(Tags_Post_list.this);

        @Override
        protected Search[] doInBackground(String... params) {
            try {
                String tag_id = params[0];
                String url = "https://faqs.solar/wp-json/wp/v2/posts?tags=" + tag_id;
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.setErrorHandler(new CustomResponseErrorHandler());
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Search[] tags_posts = restTemplate.getForObject(url, Search[].class);
                return tags_posts;


            } catch (Exception e) {
                this.progress.setMessage("");

            }




            return new Search[0];
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

            ListView listView =(ListView)findViewById(R.id.list);
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
                    Intent sendStuff = new Intent(Tags_Post_list.this, Tag_Post_Detail.class);
                    sendStuff.putExtra("title", title);
                    sendStuff.putExtra("content" , content);
                    sendStuff.putExtra("author" , author);
                    sendStuff.putExtra("tags" , tags);
                    sendStuff.putExtra("date" , date);

                    startActivity(sendStuff);









                }
            } );










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

}
