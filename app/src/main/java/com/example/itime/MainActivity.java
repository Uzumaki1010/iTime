package com.example.itime;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;

import com.example.itime.AddNew.AddNewActivity;
import com.example.itime.CDI.CountDownItem;
import com.example.itime.CDI.CountDownItemAdapter;
import com.example.itime.CDI.CountDownItemSaver;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.view.ContextMenu;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    public static final int REQUEST_CODE_ADD_NEW = 901;

    private AppBarConfiguration mAppBarConfiguration;

    private String title,note,repeat,tag;
    private int year,month,day,imageId;
    private static int current_theme=-1;
    private ArrayList<CountDownItem> CdiList=new ArrayList<>();
    private CountDownItemAdapter countDownItemAdapter;
    private FloatingActionButton fabChangeColor,fab;
    CountDownItemSaver countDownItemSaver;

    public ArrayList<CountDownItem> getCdiList(){
        return CdiList;
    }
    public CountDownItemAdapter getCountDownItemAdapter() {
        return countDownItemAdapter;
    }

    //新建事件的返回结果
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQUEST_CODE_ADD_NEW:
                if(resultCode==RESULT_OK){
                    title=data.getStringExtra("title");
                    note=data.getStringExtra("note");
                    repeat=data.getStringExtra("repeat");
                    tag=data.getStringExtra("tag");
                    year=data.getIntExtra("year",0);
                    month=data.getIntExtra("month",0);
                    day=data.getIntExtra("day",0);
                    imageId=data.getIntExtra("imageId",0);

                    CdiList.add(new CountDownItem(title,note,repeat,tag,year,month,day,imageId));
                    countDownItemAdapter.notifyDataSetChanged();
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countDownItemSaver.save();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //设置主题
        if(current_theme!=-1)
            this.setTheme(current_theme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fabChangeColor=findViewById(R.id.fab_change_color);
        fab = findViewById(R.id.fab_add_new);

        countDownItemSaver=new CountDownItemSaver(this);
        CdiList=countDownItemSaver.load();
        if(CdiList.size()==0)
            CdiList.add(new CountDownItem("Birthday","Happy Birthday","每年","生日",2020,10,7,R.drawable.image2));
        countDownItemAdapter=new CountDownItemAdapter(MainActivity.this,R.layout.list_count_down_item,CdiList);

        //设置按钮颜色
        if(current_theme!=-1){
            switch (current_theme){
                case R.style.AppTheme01:
                    fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorTheme1)));
                    fabChangeColor.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorTheme1)));
                    break;
                case R.style.AppTheme02:
                    fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorTheme2)));
                    fabChangeColor.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorTheme2)));
                    break;
                case R.style.AppTheme03:
                    fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorTheme3)));
                    fabChangeColor.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorTheme3)));
                    break;
                case R.style.AppTheme04:
                    fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorTheme4)));
                    fabChangeColor.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorTheme4)));
                    break;
                case R.style.AppTheme05:
                    fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorTheme5)));
                    fabChangeColor.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorTheme5)));
                    break;
                case R.style.AppTheme06:
                    fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorTheme6)));
                    fabChangeColor.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorTheme6)));
                    break;
                case R.style.AppTheme07:
                    fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorTheme7)));
                    fabChangeColor.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorTheme7)));
                    break;
                case R.style.AppTheme08:
                    fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorTheme8)));
                    fabChangeColor.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorTheme8)));
                    break;
            }
        }
        //更改主题颜色的点击事件
        fabChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示选择对话框
                showChooseDialog();
            }
        });

        //主界面加号的点击事件
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, AddNewActivity.class);
                intent.putExtra("title","");
                intent.putExtra("note","");
                intent.putExtra("repeat","重复设置");
                intent.putExtra("tag","添加标签");
                intent.putExtra("year",0);
                intent.putExtra("month",0);
                intent.putExtra("day",0);
                intent.putExtra("imageId",0);
                startActivityForResult(intent, REQUEST_CODE_ADD_NEW);
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_tags, R.id.nav_parts,R.id.nav_color,
                R.id.nav_prime, R.id.nav_setting, R.id.nav_about,R.id.nav_help)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    //以下为更换主题所需代码
    private int mCurrentWhich = 0;
    private int mTempWhich;
    private void showChooseDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("选择主题");
        final String[] items = new String[] {"紫色","粉色","浅蓝色","绿色","黄色","红色","橙色","蓝紫色" };
        //显示单选框,参1:单选字符串数组;参2:当前默认选中的位置;参3:选中监听
        builder.setSingleChoiceItems(items, mCurrentWhich,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mTempWhich = which;
                        Toast.makeText(MainActivity.this, items[which], Toast.LENGTH_SHORT).show();
                    }
                });

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                mCurrentWhich = mTempWhich;
                changeTheme(mCurrentWhich);
                reload();
            }
        });
        builder.setNegativeButton("取消", null);
        builder.show();
    }
    //重新启动activity
    private void reload() {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }
    //为current_theme赋值，重新启动activity时可以使用
    private void changeTheme(int mCurrentWhich) {
        switch (mCurrentWhich) {
            case 0:
                current_theme = R.style.AppTheme01;
                break;
            case 1:
                current_theme = R.style.AppTheme02;
                break;
            case 2:
                current_theme = R.style.AppTheme03;
                break;
            case 3:
                current_theme = R.style.AppTheme04;
                break;
            case 4:
                current_theme = R.style.AppTheme05;
                break;
            case 5:
                current_theme = R.style.AppTheme06;
                break;
            case 6:
                current_theme = R.style.AppTheme07;
                break;
            case 7:
                current_theme = R.style.AppTheme08;
                break;
            default:
                break;
        }
    }
}
