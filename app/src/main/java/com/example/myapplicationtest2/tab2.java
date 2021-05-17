package com.example.myapplicationtest2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplicationtest2.Adapters.GeneraListViewAdapter;
import com.example.myapplicationtest2.CustomClasses.book;

import java.util.List;

public class tab2 extends Fragment {

    List<book> bookList;

    public tab2(List<book> books) {
        this.bookList = books;
        inIt();
        // Required empty public constructor
    }

    private void inIt() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_tab2, container, false);

        RecyclerView myrv = (RecyclerView) view.findViewById(R.id.gener_list_view);
        GeneraListViewAdapter generaListViewAdapter = new GeneraListViewAdapter(getActivity(),bookList);
        myrv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false));
        myrv.setAdapter(generaListViewAdapter);
        return view;
    }
}