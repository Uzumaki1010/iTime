package com.example.itime.CDI;

import android.content.Context;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CountDownItemSaver {
    public CountDownItemSaver(Context context) {
        this.context = context;
    }

    Context context;

    public ArrayList<CountDownItem> getCountDownItems() {
        return countDownItems;
    }

    ArrayList<CountDownItem> countDownItems=new ArrayList<>();

    public void save(){
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(context.openFileOutput("Parcelable.txt", Context.MODE_PRIVATE));
            outputStream.writeObject(countDownItems);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<CountDownItem> load() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(context.openFileInput("Parcelable.txt"));
            countDownItems = (ArrayList<CountDownItem>) inputStream.readObject();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countDownItems;
    }
}
