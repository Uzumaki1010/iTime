package com.example.itime.AddNew;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itime.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddNewActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_EDIT_DATA = 902;
    public static final int REQUEST_CODE_SELECT_IMAGE = 903;

    private FloatingActionButton floatingActionButtonBack,floatingActionButtonOK;
    private EditText editTextTitle,editTextNote;
    private TextView textViewData,textViewRepeat,textViewImage,textViewAddTag;

    private String stringRepeat;
    private String stringTag;
    private int ImageId;
    private int Year,Month,Day;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case REQUEST_CODE_EDIT_DATA:                                    //获取年月日
                if(resultCode==RESULT_OK){
                    Year=data.getIntExtra("year",0);
                    Month=data.getIntExtra("month",0);
                    Day=data.getIntExtra("day",0);
                    textViewData.setText(Year+"-"+Month+"-"+Day);
                }
                break;
            case REQUEST_CODE_SELECT_IMAGE:                                 //获取图片的资源ID
                if(resultCode==RESULT_OK){
                    ImageId=data.getIntExtra("imageId",0);
                    //textViewImage.setText(ImageId);
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

        editTextTitle.setText(getIntent().getStringExtra("title"));
        editTextNote.setText(getIntent().getStringExtra("note"));
        if(getIntent().getIntExtra("year",0)==0)
            textViewData.setText("日期");
        else
            textViewData.setText(getIntent().getIntExtra("year",0)+"-" +
                getIntent().getIntExtra("month",0)+"-" +
                getIntent().getIntExtra("day",0));
        textViewRepeat.setText(getIntent().getStringExtra("repeat"));
        textViewAddTag.setText(getIntent().getStringExtra("tag"));
        ImageId=getIntent().getIntExtra("imageId",0);

        //返回
        floatingActionButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNewActivity.this.finish();
            }
        });

        //确认，并返回数据
        floatingActionButtonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("title",editTextTitle.getText().toString());
                intent.putExtra("note",editTextNote.getText().toString());
                intent.putExtra("repeat",stringRepeat);
                intent.putExtra("tag",stringTag);
                intent.putExtra("year",Year);
                intent.putExtra("month",Month);
                intent.putExtra("day",Day);
                intent.putExtra("imageId",ImageId);
                setResult(RESULT_OK,intent);
                AddNewActivity.this.finish();
            }
        });

        //选择日期
        textViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent(AddNewActivity.this, EditDateActivity.class);
                intent1.putExtra("year",1);
                intent1.putExtra("month",1);
                intent1.putExtra("day",1);
                startActivityForResult(intent1, REQUEST_CODE_EDIT_DATA);
            }
        });

        //设置重复时间
        textViewRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(AddNewActivity.this);
                builder.setIcon(R.drawable.icon_repeat);
                builder.setTitle("重复设置");

                final String[] items={"每年","每月","每周","无"};
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        stringRepeat=items[which];
                        if(stringRepeat.equals("无"))
                            Toast.makeText(AddNewActivity.this, "选择不重复" , Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(AddNewActivity.this, "选择" + items[which]+"重复一次", Toast.LENGTH_SHORT).show();
                        textViewRepeat.setText(stringRepeat);
                    }
                });
                builder.show();
            }
        });

        //选择图片
        textViewImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(AddNewActivity.this,SelectImageActivity.class);
                intent2.putExtra("imageId",0);
                startActivityForResult(intent2, REQUEST_CODE_SELECT_IMAGE);
            }
        });

        //添加标签
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
                                stringTag=sb.toString();
                            }
                        }
                        textViewAddTag.setText(stringTag);
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
