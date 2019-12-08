package com.example.itime.CDI;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Calendar;

public class CountDownItem implements Parcelable {
    private String title,note,repeat,tag;
    private int imageId;
    private int year;
    private int month;
    private int day;

    protected CountDownItem(Parcel in) {
        title = in.readString();
        note = in.readString();
        repeat = in.readString();
        tag = in.readString();
        year = in.readInt();
        month = in.readInt();
        day = in.readInt();
        imageId = in.readInt();
    }

    public static final Creator<CountDownItem> CREATOR = new Creator<CountDownItem>() {
        @Override
        public CountDownItem createFromParcel(Parcel in) {
            return new CountDownItem(in);
        }

        @Override
        public CountDownItem[] newArray(int size) {
            return new CountDownItem[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public CountDownItem(String title, String note, String repeat, String tag, int year, int month, int day,int imageId) {
        this.title = title;
        this.note = note;
        this.repeat = repeat;
        this.imageId = imageId;
        this.tag = tag;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getRestDays(){
        int mouth1[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        int mouth2[] = {31,29,31,30,31,30,31,31,30,31,30,31};
        Calendar calendar=null;
        calendar=Calendar.getInstance();
        int now_year=calendar.get(Calendar.YEAR);
        int now_month=calendar.get(Calendar.MONTH)+1;
        int now_day=calendar.get(Calendar.DATE);
        int restDays = 0;

        if(now_year%4==0&&now_year%100!=0||now_year%400==0){//闰年
            if(repeat.equals("每年")||repeat.equals("无")){
                int i=now_month;
                if(i!=month){//不等于要重复的那个月
                    restDays=restDays+mouth2[i-1]-now_day;//计算当月剩余的天数
                    i++;//下个月
                    while(i!=month){//循环
                        if(i>12){//重置月份
                            i=1;
                            continue;
                        }
                        else{//计算天数
                            restDays=restDays+mouth2[i-1];
                            i++;
                        }
                    }
                    //循环结束，到达该月
                    restDays=restDays+day;
                }
                else{//等于要重复的那个月
                    if(now_day<=day){//现在的日期在要重复的日期之前
                        restDays=restDays+day-now_day;//直接求出剩余天数
                    }
                    else{//大于
                        restDays=restDays+mouth2[i-1]-now_day;//本月剩余的天数
                        i++;//下个月
                        while(i!=month){//循环算出剩余天数
                            if(i>12){
                                i=1;
                                continue;
                            }
                            else{
                                restDays=restDays+mouth2[i-1];
                                i++;
                            }
                        }
                        //退出循环
                        restDays=restDays+day;
                    }
                }
            }
            if(repeat.equals("每月")){
                if(now_day<=day){
                    restDays=restDays+day-now_day;
                }
                else{
                    restDays=restDays+mouth2[now_month-1]-now_day+day;
                }
            }
            if(repeat.equals("每周")){
                restDays=restDays+(now_day-day)%7;
            }
        }else{//不是闰年
            if(repeat.equals("每年")||repeat.equals("无")){
                int i=now_month;
                if(i!=month){
                    restDays=restDays+mouth1[i-1]-now_day;
                    i++;
                    while(i!=month){
                        if(i>12){
                            i=1;
                            continue;
                        }
                        else{
                            restDays=restDays+mouth1[i-1];
                            i++;
                        }
                    }
                    restDays=restDays+day;
                }
                else{
                    if(now_day<=day){
                        restDays=restDays+day-now_day;
                    }
                    else{
                        restDays=restDays+mouth1[i-1]-now_day;
                        i++;
                        while(i!=month){
                            if(i>12){
                                i=1;
                                continue;
                            }
                            else{
                                restDays=restDays+mouth1[i-1];
                                i++;
                            }
                        }
                        restDays=restDays+day;
                    }
                }
            }
            if(repeat.equals("每月")){
                if(now_day<=day){
                    restDays=restDays+day-now_day;
                }
                else{
                    restDays=restDays+mouth2[now_month-1]-now_day+day;
                }
            }
            if(repeat.equals("每周")){
                restDays=restDays+(now_day-day)%7;
            }
        }
        return restDays;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(note);
        dest.writeString(repeat);
        dest.writeString(tag);
        dest.writeInt(year);
        dest.writeInt(month);
        dest.writeInt(day);
        dest.writeInt(imageId);
    }
}
