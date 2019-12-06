package com.example.itime.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.itime.CountDownItem;
import com.example.itime.CountDownItemAdapter;
import com.example.itime.CountDownItemDetailActivity;
import com.example.itime.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public static final int REQUEST_CODE_COUNT_DOWN_ITEM_DETAIL = 904;
    private CountDownItemAdapter countDownItemAdapter;
    private HomeViewModel homeViewModel;
    private ListView listViewCdi;
    private ImageView iamgeViewBackground;
    private List<CountDownItem> CdiList=new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });

        listViewCdi=root.findViewById(R.id.list_view_count_down_item);
        iamgeViewBackground=root.findViewById(R.id.image_view_back_ground);

        CdiList.add(new CountDownItem("Birthday","Happy Birthday","每年","生日",1999,10,2,R.drawable.image1));
        CdiList.add(new CountDownItem("Birthday","Happy Birthday","每年","生日",1991,10,7,R.drawable.image2));
        countDownItemAdapter=new CountDownItemAdapter(getContext(),R.layout.list_count_down_item,CdiList);
        listViewCdi.setAdapter(countDownItemAdapter);
        iamgeViewBackground.setImageResource(CdiList.get(0).getImageId());

        listViewCdi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getContext(), CountDownItemDetailActivity.class);
                intent.putExtra("position",position);
                startActivityForResult(intent, REQUEST_CODE_COUNT_DOWN_ITEM_DETAIL);
            }
        });
        return root;
    }
}