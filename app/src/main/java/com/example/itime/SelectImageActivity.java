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
    private String selectImageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_image);

        floatingActionButtonCancel=(FloatingActionButton)findViewById(R.id.floating_action_button_cancel);
        floatingActionButtonConfirm=(FloatingActionButton)findViewById(R.id.floating_action_button_confirm);

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
    }
}
