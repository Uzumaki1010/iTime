package com.example.itime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.widget.EditText;

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
        floatingActionButtonBack=(FloatingActionButton)findViewById(R.id.floating_action_button_ok);
        editTextTitle=(EditText)findViewById(R.id.edit_text_title);
        editTextNote=(EditText)findViewById(R.id.edit_text_note);
    }
}
