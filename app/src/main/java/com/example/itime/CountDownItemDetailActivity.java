package com.example.itime;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itime.AddNew.AddNewActivity;
import com.example.itime.CDI.CountDownItem;
import com.example.itime.ui.home.HomeFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

public class CountDownItemDetailActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_EDIT_COUNT_DOWN_ITEM = 905;
    private int position;
    private ImageView imageViewBack;
    private FloatingActionButton floatingActionButtonReturn,floatingActionButtonEdit,floatingActionButtonDelete;
    private TextView textViewShowTitle,textViewShowCountDown,textViewShowDate;
    private ArrayList<CountDownItem> CdiList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down_item_detail);

        imageViewBack=findViewById(R.id.image_view_back);
        floatingActionButtonReturn=findViewById(R.id.floating_action_button_return);
        floatingActionButtonEdit=findViewById(R.id.floating_action_button_edit);
        floatingActionButtonDelete=findViewById(R.id.floating_action_button_delete);
        textViewShowTitle=findViewById(R.id.text_view_show_title);
        textViewShowCountDown=findViewById(R.id.text_view_show_count_down);
        textViewShowDate=findViewById(R.id.text_view_show_data);

        position=getIntent().getIntExtra("position",0);
        CdiList=getIntent().getParcelableArrayListExtra("list");

        //显示倒计时项目的详情
        imageViewBack.setImageResource(CdiList.get(position).getImageId());
        textViewShowTitle.setText(CdiList.get(position).getTitle());
        textViewShowCountDown.setText("还剩"+CdiList.get(position).getRestDays()+"天");
        textViewShowDate.setText(CdiList.get(position).getYear()+"年"+CdiList.get(position).getMonth()+"月"+CdiList.get(position).getDay()+"日");

        //返回的点击事件
        floatingActionButtonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("position",position);
                intent.putExtra("title",CdiList.get(position).getTitle());
                intent.putExtra("note",CdiList.get(position).getNote());
                intent.putExtra("repeat",CdiList.get(position).getRepeat());
                intent.putExtra("tag",CdiList.get(position).getTag());
                intent.putExtra("year",CdiList.get(position).getYear());
                intent.putExtra("month",CdiList.get(position).getMonth());
                intent.putExtra("day",CdiList.get(position).getDay());
                intent.putExtra("imageId",CdiList.get(position).getImageId());
                setResult(RESULT_FIRST_USER,intent);
                CountDownItemDetailActivity.this.finish();
            }
        });

        //编辑的点击事件,跳转至新建界面
        floatingActionButtonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CountDownItemDetailActivity.this, AddNewActivity.class);
                intent.putExtra("title",CdiList.get(position).getTitle());
                intent.putExtra("note",CdiList.get(position).getNote());
                intent.putExtra("repeat",CdiList.get(position).getRepeat());
                intent.putExtra("tag",CdiList.get(position).getTag());
                intent.putExtra("year",CdiList.get(position).getYear());
                intent.putExtra("month",CdiList.get(position).getMonth());
                intent.putExtra("day",CdiList.get(position).getDay());
                startActivityForResult(intent, REQUEST_CODE_EDIT_COUNT_DOWN_ITEM);
            }
        });

        //删除的点击事件
        floatingActionButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("position",position);
                setResult(RESULT_OK,intent);
                CountDownItemDetailActivity.this.finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            CdiList.get(position).setTitle(data.getStringExtra("title"));
            CdiList.get(position).setNote(data.getStringExtra("note"));
            CdiList.get(position).setRepeat(data.getStringExtra("repeat"));
            CdiList.get(position).setTag(data.getStringExtra("tag"));
            CdiList.get(position).setYear(data.getIntExtra("year",0));
            CdiList.get(position).setMonth(data.getIntExtra("month",0));
            CdiList.get(position).setDay(data.getIntExtra("day",0));
            CdiList.get(position).setImageId(data.getIntExtra("imageId",0));

            imageViewBack.setImageResource(data.getIntExtra("imageId",0));
            textViewShowTitle.setText(data.getStringExtra("title"));
            textViewShowCountDown.setText("还剩"+CdiList.get(position).getRestDays()+"天");
            textViewShowDate.setText(data.getIntExtra("year",0)+"年"+
                    data.getIntExtra("month",0)+"月"+
                    data.getIntExtra("day",0)+"日");
        }
    }
}
