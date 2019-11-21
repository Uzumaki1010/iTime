package com.example.itime;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CountDownItemListFragment extends Fragment {

    private CountDownItemAdapter countDownItemAdapter;
    public CountDownItemListFragment(CountDownItemAdapter countDownItemAdapter) {
        this.countDownItemAdapter=countDownItemAdapter;
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_home, container, false);
        ListView listViewCdis=view.findViewById(R.id.list_view_count_down_item);
        listViewCdis.setAdapter(countDownItemAdapter);
        this.registerForContextMenu(listViewCdis);
        return view;
    }
}
