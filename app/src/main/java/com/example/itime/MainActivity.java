package com.example.itime;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.itime.ui.home.HomeFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_ADD_NEW = 901;
    private AppBarConfiguration mAppBarConfiguration;

    private List<CountDownItem> listCountDownItem=new ArrayList<>();
    CountDownItemAdapter countDownItemAdapter;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQUEST_CODE_ADD_NEW:
                if(resultCode==RESULT_OK){
                    String title=data.getStringExtra("title");
                    String note=data.getStringExtra("note");
                    String repeat=data.getStringExtra("repeat");
                    String tag=data.getStringExtra("tag");
                    String stringYear=data.getStringExtra("year");
                    String stringMonth=data.getStringExtra("month");
                    String stringDay=data.getStringExtra("day");
                    String stringImageId=data.getStringExtra("imageId");
                    //int year=Integer.parseInt(stringYear);
                    //int month=Integer.valueOf(data.getStringExtra("month")).intValue();
                    //int day=Integer.valueOf(data.getStringExtra("day")).intValue();
                    //int imageId=Integer.valueOf(data.getStringExtra("imageId")).intValue();
                    //listCountDownItem.add(new CountDownItem(title,note,repeat,tag,Integer.parseInt(stringYear),Integer.parseInt(stringMonth),Integer.parseInt(stringDay),Integer.parseInt(stringImageId)));
                    //countDownItemAdapter.notifyDataSetChanged();
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
        FloatingActionButton fab = findViewById(R.id.fab_add_new);

        /*
        countDownItemAdapter=new CountDownItemAdapter(MainActivity.this,R.layout.list_count_down_item,listCountDownItem);
        HomeFragment fragment=new HomeFragment(countDownItemAdapter);

         */

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,AddNewActivity.class);
                intent.putExtra("title","无");
                intent.putExtra("note","无");
                intent.putExtra("year","1900");
                intent.putExtra("month","1");
                intent.putExtra("day","1");
                intent.putExtra("repeat","无");
                intent.putExtra("imageId","0");
                intent.putExtra("tag","无");
                startActivityForResult(intent, REQUEST_CODE_ADD_NEW);
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
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

    /*
    public class CountDownItemAdapter extends ArrayAdapter<CountDownItem> {

        private int resourceId;

        public CountDownItemAdapter(@NonNull Context context, int resource, @NonNull List<CountDownItem> objects) {
            super(context, resource, objects);
            resourceId=resource;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CountDownItem countDownItem = getItem(position);//获取当前项的实例
            View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            ((ImageView) view.findViewById(R.id.image_view_cdi_background)).setImageResource(0-countDownItem.getImageId());
            ((TextView) view.findViewById(R.id.text_view_cdi_title)).setText(countDownItem.getTitle());
            ((TextView)view.findViewById(R.id.text_view_cdi_date)).setText(countDownItem.getYear()+"年"+countDownItem.getMonth()+"月"+countDownItem.getDay()+"日");
            ((TextView)view.findViewById(R.id.text_view_cdi_note)).setText(countDownItem.getNote());
            return view;
        }
    }

     */
}
