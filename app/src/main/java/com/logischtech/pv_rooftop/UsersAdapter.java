package com.logischtech.pv_rooftop;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.logischtech.pv_rooftop.Models.Search;

/**
 * Created by Aayushi.Garg on 29-06-2017.
 */

public class UsersAdapter extends BaseAdapter {

    private Activity activity;
 //   Context context ;
    private Search[] data;
    private Context ApplicationContext = null;

    private static LayoutInflater inflater=null;
    int layoutResourceId;




    public UsersAdapter(Activity usersActivity, Search[] exam , Context appContext) {

        activity = usersActivity ;
        data = exam ;
        ApplicationContext = appContext;

        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);



    }


    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        Typeface tf1,tf2 ;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row, null);
       // LayoutInflater inflater = ((Activity)context).getLayoutInflater();
       // vi = inflater.inflate(layoutResourceId, parent, false);


        TextView tv_title = (TextView)vi.findViewById(R.id.tv_title);
        TextView tv_ans = (TextView)vi.findViewById(R.id.tv_ans);
        tf1 = Typeface.createFromAsset(ApplicationContext.getAssets(), "Montserrat/Montserrat-SemiBold.ttf");
        tf2 = Typeface.createFromAsset(ApplicationContext.getAssets(), "Montserrat/Montserrat-Medium.ttf");
        tv_title.setTypeface(tf1);
        tv_ans.setTypeface(tf2);

        Search user = new Search();
        user = data[position];

        String  sub  = "&#038;" ;
        String otherStr = "&" ;
        String title_c = user.getTitle().getRendered().toString() ;
        String ans_c = user.getContent().getRendered().toString();



         String title_rs = title_c.replace(sub, otherStr);
        String answer_rs = ans_c.replace(sub , otherStr);




       // String str ="part1 part2 part3";

       // String temp = answer_rs.substring(0, answer_rs.lastIndexOf(",")) + replaceWith + answer_rs.substring(answer_rs.lastIndexOf(",") + 1);


        tv_title.setText(Html.fromHtml(title_rs));
        tv_ans.setText(Html.fromHtml(answer_rs));

        return vi;
    }
}
