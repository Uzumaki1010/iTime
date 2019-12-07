package com.example.itime.AddNew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.itime.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EditDataActivity extends AppCompatActivity {

    private FloatingActionButton floatingActionButtonCancel,floatingActionButtonConfirm;
    private EditText editTextYear,editTextMonth,editTextData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);

        floatingActionButtonCancel=(FloatingActionButton)findViewById(R.id.floating_action_button_cancel);
        floatingActionButtonConfirm=(FloatingActionButton)findViewById(R.id.floating_action_button_confirm);
        editTextYear=(EditText)findViewById(R.id.edit_text_year);
        editTextMonth=(EditText)findViewById(R.id.edit_text_month);
        editTextData=(EditText)findViewById(R.id.edit_text_day);

        //返回
        floatingActionButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditDataActivity.this.finish();
            }
        });

        //确认
        floatingActionButtonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent();
                intent1.putExtra("year",Integer.valueOf(editTextYear.getText().toString()).intValue());
                intent1.putExtra("month",Integer.valueOf(editTextMonth.getText().toString()).intValue());
                intent1.putExtra("day",Integer.valueOf(editTextData.getText().toString()).intValue());
                setResult(RESULT_OK,intent1);
                EditDataActivity.this.finish();
            }
        });
    }
}
