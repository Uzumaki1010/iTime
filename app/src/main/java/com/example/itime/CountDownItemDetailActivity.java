package com.example.itime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.itime.CDI.CountDownItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

public class CountDownItemDetailActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_EDIT_COUNT_DOWN_ITEM = 905;
    private int position;
    private ImageView imageViewBack;
    private FloatingActionButton floatingActionButtonReturn,floatingActionButtonEdit,floatingActionButtonDelete;
    private ArrayList<CountDownItem> CdiList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down_item_detail);

        imageViewBack=findViewById(R.id.image_view_back);
        floatingActionButtonReturn=findViewById(R.id.floating_action_button_return);
        floatingActionButtonEdit=findViewById(R.id.floating_action_button_edit);
        floatingActionButtonDelete=findViewById(R.id.floating_action_button_delete);

        position=getIntent().getIntExtra("position",0);
        CdiList=getIntent().getParcelableArrayListExtra("list");
        int imageId=CdiList.get(position).getImageId();
        imageViewBack.setImageResource(imageId);

        floatingActionButtonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownItemDetailActivity.this.finish();
            }
        });

        floatingActionButtonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CountDownItemDetailActivity.this,EditCountDownItemActivity.class);
                intent.putExtra("title",CdiList.get(position).getTitle());
                intent.putExtra("note",CdiList.get(position).getNote());
                intent.putExtra("repeat",CdiList.get(position).getRepeat());
                intent.putExtra("tag",CdiList.get(position).getTag());
                intent.putExtra("year",CdiList.get(position).getYear());
                intent.putExtra("month",CdiList.get(position).getMonth());
                intent.putExtra("day",CdiList.get(position).getDay());
                startActivityForResult(intent, REQUEST_CODE_EDIT_COUNT_DOWN_ITEM);
                CountDownItemDetailActivity.this.finish();
            }
        });

        floatingActionButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownItemDetailActivity.this.finish();
            }
        });
    }
}
