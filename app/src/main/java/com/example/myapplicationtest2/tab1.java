package com.example.myapplicationtest2;

import android.graphics.Rect;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplicationtest2.Adapters.RecycleviewAdapter;
import com.example.myapplicationtest2.CustomClasses.book;
import com.example.myapplicationtest2.ItemDecoration.GridSpacingItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class tab1 extends Fragment {
    public List<book> bookList;
    String []generaList = {"Science Fiction","Fantasy","Fiction","Horror","Young Adult","Historical","Adventure"};

    public tab1(List<book> books) {
        this.bookList = books;
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);
        RecyclerView myrv = (RecyclerView) view.findViewById(R.id.recyclerview);
        RecycleviewAdapter myAdapter = new RecycleviewAdapter(getActivity(),bookList);
        myrv.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL,false));
        RecyclerView myrv2 = (RecyclerView) view.findViewById(R.id.recyclerviewAll);
        myrv2.setLayoutManager(new GridLayoutManager(getActivity(),3));
        int spanCount = 3; // 3 columns
        myrv2.addItemDecoration(new GridSpacingItemDecoration(spanCount,60));
        myrv.setAdapter(myAdapter);
        myrv2.setAdapter(myAdapter);

        return view;
    }


}

