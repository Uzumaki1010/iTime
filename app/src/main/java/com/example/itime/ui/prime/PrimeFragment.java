package com.example.itime.ui.prime;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.itime.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PrimeFragment extends Fragment {


    public PrimeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_prime, container, false);
    }

}
