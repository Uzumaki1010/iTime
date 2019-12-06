package com.example.itime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EditCountDownItemActivity extends AppCompatActivity {

    private int position;
    private EditText editTextTitle,editTextNote;
    private TextView textViewData,textViewRepeat,textViewTag;
    private FloatingActionButton floatingActionButtonBack,floatingActionButtonOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_count_down_item);

        editTextTitle=findViewById(R.id.edit_text_title);
        editTextNote=findViewById(R.id.edit_text_note);
        textViewData=findViewById(R.id.text_view_data);
        textViewRepeat=findViewById(R.id.text_view_repeat);
        textViewTag=findViewById(R.id.text_view_addtag);
        floatingActionButtonBack=findViewById(R.id.floating_action_button_back);
        floatingActionButtonOk=findViewById(R.id.floating_action_button_ok);
        position=getIntent().getIntExtra("position",0);
        //要改
        editTextTitle.setText("1");
        editTextNote.setText("2");
        textViewData.setText("3");
        textViewRepeat.setText("4");
        textViewTag.setText("5");

        floatingActionButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditCountDownItemActivity.this.finish();
            }
        });

        floatingActionButtonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                setResult(RESULT_OK,intent);
                EditCountDownItemActivity.this.finish();
            }
        });
    }
}
