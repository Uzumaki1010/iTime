package com.example.itime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SelectImageActivity extends AppCompatActivity {

    Context context;
    private FloatingActionButton floatingActionButtonCancel, floatingActionButtonConfirm;
    private ImageView imageView1, imageView2, imageView3, imageView4;
    private int selectImageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_image);

        context=getBaseContext();

        floatingActionButtonCancel = (FloatingActionButton) findViewById(R.id.floating_action_button_cancel);
        floatingActionButtonConfirm = (FloatingActionButton) findViewById(R.id.floating_action_button_confirm);

        //只能放四张图片
        imageView1 = (ImageView) findViewById(R.id.image_view1);
        imageView1.setImageResource(R.drawable.image1);
        imageView2 = (ImageView) findViewById(R.id.image_view2);
        imageView2.setImageResource(R.drawable.image2);
        imageView3 = (ImageView) findViewById(R.id.image_view3);
        imageView3.setImageResource(R.drawable.image3);
        imageView4 = (ImageView) findViewById(R.id.image_view4);
        imageView4.setImageResource(R.drawable.image4);

        //返回
        floatingActionButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectImageActivity.this.finish();
            }
        });

        //确认
        floatingActionButtonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.putExtra("imageId", selectImageId);                  //传回imageId
                setResult(RESULT_OK, intent2);
                SelectImageActivity.this.finish();
            }
        });

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImageId = context.getResources().getIdentifier("image1", "drawable", context.getPackageName());
                Toast.makeText(SelectImageActivity.this, "你选择了这张图片", Toast.LENGTH_SHORT).show();
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImageId = context.getResources().getIdentifier("image2", "drawable", context.getPackageName());
                Toast.makeText(SelectImageActivity.this, "你选择了这张图片", Toast.LENGTH_SHORT).show();
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImageId = context.getResources().getIdentifier("image3", "drawable", context.getPackageName());
                Toast.makeText(SelectImageActivity.this, "你选择了这张图片", Toast.LENGTH_SHORT).show();
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImageId = context.getResources().getIdentifier("image4", "drawable", context.getPackageName());
                Toast.makeText(SelectImageActivity.this, "你选择了这张图片", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
