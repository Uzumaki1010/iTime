package com.example.itime;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
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

    public static final int REQUEST_CODE_EDIT_DATA = 902;
    public static final int REQUEST_CODE_EDIT_IMAGE = 903;
    private FloatingActionButton floatingActionButtonBack,floatingActionButtonOK;
    private EditText editTextTitle,editTextNote;
    private TextView textViewData,textViewRepeat,textViewImage,textViewAddTag;
    private String year,month,day;
    private String stringRepeat;
    private String stringImageId;
    private String stringsAddTag;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case REQUEST_CODE_EDIT_DATA:
                if(resultCode==RESULT_OK){
                    year=data.getStringExtra("year");
                    month=data.getStringExtra("month");
                    day=data.getStringExtra("day");
                    String ymd=year+"-"+month+"-"+day;
                    textViewData.setText(ymd);
                }
                break;
            case REQUEST_CODE_EDIT_IMAGE:
                if(resultCode==RESULT_OK){
                    stringImageId=data.getStringExtra("imageID");
                    //textViewImage.setText(stringImageId);
                }
                break;
        }
    }

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
                intent.putExtra("year","1");
                intent.putExtra("month","1");
                intent.putExtra("day","1");
                startActivityForResult(intent, REQUEST_CODE_EDIT_DATA);
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
                        stringRepeat=items[which];
                        textViewRepeat.setText(stringRepeat);
                    }
                });
                builder.show();
            }
        });

        textViewImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddNewActivity.this,SelectImageActivity.class);
                intent.putExtra("imageID","0");
                startActivityForResult(intent, REQUEST_CODE_EDIT_IMAGE);
            }
        });

        textViewAddTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AddNewActivity.this);
                builder.setTitle("添加标签");

                final String items[] = { "生日", "学习", "工作", "节假日" };
                final boolean[] checkedItems = { true, false, false, false, true };
                builder.setMultiChoiceItems(items, checkedItems,
                        new DialogInterface.OnMultiChoiceClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which,
                                                boolean isChecked) {

                            }
                        });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuffer sb = new StringBuffer();
                        for (int i = 0; i < items.length; i++) {
                            // 判断一下 选中的
                            if (checkedItems[i]) {
                                String choice = items[i];
                                sb.append(choice + " ");
                                stringsAddTag=sb.toString();
                            }
                        }
                        textViewAddTag.setText(stringsAddTag);
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });
    }
}
