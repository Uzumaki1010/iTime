package com.example.itime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.itime.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddNewActivity extends AppCompatActivity {

    private FloatingActionButton floatingActionButtonBack,floatingActionButtonOK;
    private EditText editTextTitle,editTextNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        floatingActionButtonBack=(FloatingActionButton)findViewById(R.id.floating_action_button_back);
        floatingActionButtonOK=(FloatingActionButton)findViewById(R.id.floating_action_button_ok);
        editTextTitle=(EditText)findViewById(R.id.edit_text_title);
        editTextNote=(EditText)findViewById(R.id.edit_text_note);

        floatingActionButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNewActivity.this.finish();
            }
        });

        floatingActionButtonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("title",editTextTitle.getText().toString());
                intent.putExtra("note",editTextNote.getText().toString());
                setResult(RESULT_OK,intent);
                AddNewActivity.this.finish();
            }
        });
    }
}
