package com.example.itime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CountDownItemDetailActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_EDIT_COUNT_DOWN_ITEM = 905;
    private int position;
    private ImageView imageViewBack;
    private FloatingActionButton floatingActionButtonReturn,floatingActionButtonEdit,floatingActionButtonDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down_item_detail);

        imageViewBack=findViewById(R.id.image_view_back);
        floatingActionButtonReturn=findViewById(R.id.floating_action_button_return);
        floatingActionButtonEdit=findViewById(R.id.floating_action_button_edit);
        floatingActionButtonDelete=findViewById(R.id.floating_action_button_delete);

        position=getIntent().getIntExtra("position",0);
        imageViewBack.setImageResource(R.drawable.image1);

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
                intent.putExtra("position",position);
                startActivityForResult(intent, REQUEST_CODE_EDIT_COUNT_DOWN_ITEM);
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
