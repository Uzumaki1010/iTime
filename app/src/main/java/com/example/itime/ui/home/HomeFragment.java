package com.example.itime.ui.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.itime.CDI.CountDownItem;
import com.example.itime.CDI.CountDownItemAdapter;
import com.example.itime.CountDownItemDetailActivity;
import com.example.itime.MainActivity;
import com.example.itime.R;

import java.util.ArrayList;

import static android.app.Activity.RESULT_FIRST_USER;
import static android.app.Activity.RESULT_OK;

public class HomeFragment extends Fragment {

    public static final int REQUEST_CODE_COUNT_DOWN_ITEM_DETAIL = 904;
    private CountDownItemAdapter countDownItemAdapter;
    private ListView listViewCdi;
    private ImageView imageViewBackground;
    private ArrayList<CountDownItem> CdiList;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        countDownItemAdapter=((MainActivity)context).getCountDownItemAdapter();
        CdiList=((MainActivity)context).getCdiList();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        listViewCdi=root.findViewById(R.id.list_view_count_down_item);
        imageViewBackground=root.findViewById(R.id.image_view_back_ground);
        if(CdiList.size()!=0)
            imageViewBackground.setImageResource(CdiList.get(0).getImageId());
        listViewCdi.setAdapter(countDownItemAdapter);

        listViewCdi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getContext(),CountDownItemDetailActivity.class);
                intent.putExtra("position",position);
                intent.putExtra("list",CdiList);
                startActivityForResult(intent,REQUEST_CODE_COUNT_DOWN_ITEM_DETAIL);
            }
        });
        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(resultCode) {
            case RESULT_OK:
                if(data.getIntExtra("position",0)==0) {
                     imageViewBackground.setImageResource(CdiList.get(1).getImageId());
                }
                CdiList.remove(data.getIntExtra("position",0));
                countDownItemAdapter.notifyDataSetChanged();
                break;
            case RESULT_FIRST_USER:
                int p=data.getIntExtra("position",0);
                CdiList.get(p).setTitle(data.getStringExtra("title"));
                CdiList.get(p).setNote(data.getStringExtra("note"));
                CdiList.get(p).setRepeat(data.getStringExtra("repeat"));
                CdiList.get(p).setTag(data.getStringExtra("tag"));
                CdiList.get(p).setYear(data.getIntExtra("year",0));
                CdiList.get(p).setMonth(data.getIntExtra("month",0));
                CdiList.get(p).setDay(data.getIntExtra("day",0));
                CdiList.get(p).setImageId(data.getIntExtra("imageId",0));
                if(p==0){
                    imageViewBackground.setImageResource(data.getIntExtra("imageId",0));
                }
                countDownItemAdapter.notifyDataSetChanged();
        }
    }
}
