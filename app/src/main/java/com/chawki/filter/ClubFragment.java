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
 * A simple {@link Fragment} subclass.
 */
public class ClubFragment extends Fragment {


    protected RecyclerView recyclerView;
    private List<Model> list;
    private RecyclerAdapter adapter;

    public ClubFragment() {
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
        list.add(new Model(R.drawable.party1,"GRAND REX BIGHT CLUB","Center Stage Mall, New York","4.6","256","2.5 KM"));
        list.add(new Model(R.drawable.party2,"GRAVITY CLUB","Roofop Nightclub at The Gardens Mall","4.1","14","2.7 KM"));
        list.add(new Model(R.drawable.party3,"ICE CUBE","The Great India Place, Third Floor, 313","4.1","14","2.7 KM"));

        adapter = new RecyclerAdapter(getContext(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }
}
