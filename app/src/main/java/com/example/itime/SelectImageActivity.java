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

    private FloatingActionButton floatingActionButtonCancel, floatingActionButtonConfirm;
    private ImageView imageView1, imageView2, imageView3, imageView4;
    private String selectImageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_image);

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
        //imageView5=(ImageView)findViewById(R.id.image_view5);
        //imageView5.setImageResource(R.drawable.image5);
        //imageView6=(ImageView)findViewById(R.id.image_view6);
        //imageView6.setImageResource(R.drawable.image6);
        //imageView7=(ImageView)findViewById(R.id.image_view7);
        //imageView7.setImageResource(R.drawable.image7);
        //imageView8=(ImageView)findViewById(R.id.image_view8);
        //imageView8.setImageResource(R.drawable.image8);

        floatingActionButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectImageActivity.this.finish();
            }
        });

        floatingActionButtonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.putExtra("imageId", selectImageId);
                setResult(RESULT_OK, intent2);
                SelectImageActivity.this.finish();
            }
        });

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImageId = "700065";
                Toast.makeText(SelectImageActivity.this, "你选择了这张图片", Toast.LENGTH_SHORT).show();
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImageId = "700066";
                Toast.makeText(SelectImageActivity.this, "你选择了这张图片", Toast.LENGTH_SHORT).show();
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImageId = "700052";
                Toast.makeText(SelectImageActivity.this, "你选择了这张图片", Toast.LENGTH_SHORT).show();
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImageId = "700054";
                Toast.makeText(SelectImageActivity.this, "你选择了这张图片", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
