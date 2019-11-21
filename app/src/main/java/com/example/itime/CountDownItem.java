package com.example.itime;

public class CountDownItem {
    private String title,note,repeat,tag;
    private int imageId;
    private int year;
    private int month;
    private int day;

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
}
