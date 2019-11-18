package com.example.itime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itime.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class AddNewActivity extends AppCompatActivity {

    private FloatingActionButton floatingActionButtonBack,floatingActionButtonOK;
    private EditText editTextTitle,editTextNote;
    private TextView textViewData,textViewRepeat,textViewImage,textViewAddTag;
    private String stringRepeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        floatingActionButtonBack=(FloatingActionButton)findViewById(R.id.floating_action_button_back);
        floatingActionButtonOK=(FloatingActionButton)findViewById(R.id.floating_action_button_ok);
        editTextTitle=(EditText)findViewById(R.id.edit_text_title);
        editTextNote=(EditText)findViewById(R.id.edit_text_note);
        textViewData=(TextView)findViewById(R.id.text_view_data);
        textViewRepeat=(TextView)findViewById(R.id.text_view_repeat);
        textViewImage=(TextView)findViewById(R.id.text_view_image);
        textViewAddTag=(TextView)findViewById(R.id.text_view_addtag);

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

        textViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(AddNewActivity.this,EditDataActivity.class);
                intent.putExtra("year","1900");
                intent.putExtra("month","1");
                intent.putExtra("data","1");
                startActivityForResult(intent,902);
            }
        });

        textViewRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(AddNewActivity.this);
                builder.setIcon(R.drawable.icon_repeat);
                builder.setTitle("重复设置");

                final String[] items={"每年","每月","每日"};
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        stringRepeat=items[which];
                        Toast.makeText(AddNewActivity.this, "选择" + items[which]+"重复一次", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
    }
}
