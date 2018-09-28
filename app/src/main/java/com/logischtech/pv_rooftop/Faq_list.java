package com.logischtech.pv_rooftop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class Faq_list extends AppCompatActivity {

    TextView tv_title , tv_content , tv_date , tv_author , tv_tags ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq_list);
        Intent intent = getIntent();
        String result = intent.getStringExtra("MY_KEY");
        String result1 = intent.getStringExtra("MY_KEY1");






//        ListView listView =(ListView)findViewById(R.id.list);
//        Utility.setListViewHeightBasedOnChildren(listView);
//
//        UsersAdapter adapter=new UsersAdapter(usersActivity, exam);
//        listView.setAdapter(adapter);




    }
}
