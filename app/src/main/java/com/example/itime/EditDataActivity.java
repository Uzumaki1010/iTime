package com.example.itime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        editTextData=(EditText)findViewById(R.id.edit_text_data);

        floatingActionButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditDataActivity.this.finish();
            }
        });

        floatingActionButtonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("year",editTextYear.getText().toString());
                intent.putExtra("month",editTextMonth.getText().toString());
                intent.putExtra("day",editTextData.getText().toString());
                setResult(RESULT_OK,intent);
                EditDataActivity.this.finish();
            }
        });
    }
}
