package com.example.itime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SelectImageActivity extends AppCompatActivity {

    private FloatingActionButton floatingActionButtonCancel,floatingActionButtonConfirm;
    private ImageView imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9;
    private String selectImageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_image);

        floatingActionButtonCancel=(FloatingActionButton)findViewById(R.id.floating_action_button_cancel);
        floatingActionButtonConfirm=(FloatingActionButton)findViewById(R.id.floating_action_button_confirm);
        imageView2=(ImageView)findViewById(R.id.imageView2);
        imageView3=(ImageView)findViewById(R.id.imageView3);
        imageView4=(ImageView)findViewById(R.id.imageView4);
        imageView5=(ImageView)findViewById(R.id.imageView5);
        imageView6=(ImageView)findViewById(R.id.imageView6);
        imageView7=(ImageView)findViewById(R.id.imageView7);
        imageView8=(ImageView)findViewById(R.id.imageView8);
        imageView9=(ImageView)findViewById(R.id.imageView9);

        floatingActionButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectImageActivity.this.finish();
            }
        });

        floatingActionButtonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("image",selectImageId);
                setResult(RESULT_OK,intent);
                SelectImageActivity.this.finish();
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SelectImageActivity.this, "你选择了这张图片！" , Toast.LENGTH_SHORT).show();
                selectImageId="imageView2";
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SelectImageActivity.this, "你选择了这张图片！" , Toast.LENGTH_SHORT).show();
                selectImageId="imageView3";
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SelectImageActivity.this, "你选择了这张图片！" , Toast.LENGTH_SHORT).show();
                selectImageId="imageView4";
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SelectImageActivity.this, "你选择了这张图片！" , Toast.LENGTH_SHORT).show();
                selectImageId="imageView5";
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SelectImageActivity.this, "你选择了这张图片！" , Toast.LENGTH_SHORT).show();
                selectImageId="imageView6";
            }
        });
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SelectImageActivity.this, "你选择了这张图片！" , Toast.LENGTH_SHORT).show();
                selectImageId="imageView7";
            }
        });
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SelectImageActivity.this, "你选择了这张图片！" , Toast.LENGTH_SHORT).show();
                selectImageId="imageView8";
            }
        });
        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SelectImageActivity.this, "你选择了这张图片！" , Toast.LENGTH_SHORT).show();
                selectImageId="imageView9";
            }
        });
    }
}
