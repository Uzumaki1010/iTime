package com.example.itime;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.view.View;

import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_ADD_NEW = 901;
    private AppBarConfiguration mAppBarConfiguration;
    private String title,note,repeat,tag;
    private int year,month,day,imageId;
    private List<CountDownItem> CdiList=new ArrayList<>();

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
                    getCdiList().add(new CountDownItem(title,note,repeat,tag,year,month,day,imageId));
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //主界面加号的点击事件
        FloatingActionButton fab = findViewById(R.id.fab_add_new);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,AddNewActivity.class);
                intent.putExtra("title","无");
                intent.putExtra("note","无");
                intent.putExtra("repeat","无");
                intent.putExtra("tag","无");
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

    public List<CountDownItem> getCdiList() {
        return CdiList;
    }
}
