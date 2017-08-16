package com.chawki.filter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DEV-PC on 20/07/2017.
 */

public class EventsFragment  extends Fragment {


    protected RecyclerView recyclerView;
    private List<Model> list;
    private RecyclerAdapter adapter;

    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_club, container, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        setupAdapter();
    }

    private void setupAdapter() {

        list = new ArrayList<>();
        list.add(new Model(R.drawable.event1, "THE SUPER BOWL", "Madison Square Garden, New York", "5", "5K", "26.5 KM"));
        list.add(new Model(R.drawable.event2, "SKATING REGIONALS", "Salt Lake City", "4.8", "525", "266.7 KM"));
        list.add(new Model(R.drawable.event3, "ONE REPABLIC CONCERT", "Madison Square Garden, New York", "4.3", "800", "66.7 KM"));

        adapter = new RecyclerAdapter(getContext(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }
}
