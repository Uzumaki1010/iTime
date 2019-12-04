package com.example.itime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.Calendar;
import java.util.List;

public class CountDownItemAdapter extends ArrayAdapter<CountDownItem> {

    private int resourceId;

    public CountDownItemAdapter(@NonNull Context context, int resource, @NonNull List<CountDownItem> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CountDownItem countDownItem = getItem(position);//获取当前项的实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

        Calendar calendar=null;
        calendar=Calendar.getInstance();
        int now_year=calendar.get(Calendar.YEAR);
        int now_month=calendar.get(Calendar.MONTH)+1;
        int now_day=calendar.get(Calendar.DATE);
        int now_hour = calendar.get(Calendar.HOUR_OF_DAY);
        int now_minute = calendar.get(Calendar.MINUTE);
        int now_second = calendar.get(Calendar.SECOND);

        if(now_year%4==0&&now_year%100!=0||now_year%400==0){//闰年
            if(countDownItem.getRepeat().equals("每年")){

            }
            if(countDownItem.getRepeat().equals("每月")){

            }
            if(countDownItem.getRepeat().equals("每日")){

            }
        }else{//不是闰年
            if(countDownItem.getRepeat().equals("每年")){

            }
            if(countDownItem.getRepeat().equals("每月")){

            }
            if(countDownItem.getRepeat().equals("每日")){

            }
        }

        ((ImageView) view.findViewById(R.id.image_view_cdi_background)).setImageResource(countDownItem.getImageId());
        ((TextView) view.findViewById(R.id.text_view_cdi_title)).setText(countDownItem.getTitle());
        ((TextView)view.findViewById(R.id.text_view_cdi_date)).setText(countDownItem.getYear()+"年"+countDownItem.getMonth()+"月"+countDownItem.getDay()+"日");
        ((TextView)view.findViewById(R.id.text_view_cdi_note)).setText(countDownItem.getNote());
        ((TextView)view.findViewById(R.id.text_view_cdi_count_down)).setText("还剩"+'\n'+"23小时");
        return view;
    }
}
