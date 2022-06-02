package com.app.moodverse;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public String emotions;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        ImageButton today_analytics =(ImageButton) v.findViewById(R.id.today_analytics);
        today_analytics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=null;
                fragment = new AnalyticsFragment();
                getFragmentManager().beginTransaction().replace(R.id.body_container,fragment).commit();
            }
        });

        Button ext_neg =(Button) v.findViewById(R.id.ext_neg);
        ext_neg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emotions+=2;
            }
        });

        Button neg =(Button) v.findViewById(R.id.neg);
        neg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emotions+=4;
            }
        });

        Button neu =(Button) v.findViewById(R.id.neu);
        neu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emotions+=6;
            }
        });

        Button pos =(Button) v.findViewById(R.id.pos);
        pos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emotions+=8;
            }
        });

        Button ext_pos =(Button) v.findViewById(R.id.ext_pos);
        ext_pos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emotions+=10;
            }
        });
        return v;
    }
}