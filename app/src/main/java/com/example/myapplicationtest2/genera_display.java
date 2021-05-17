package com.example.myapplicationtest2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplicationtest2.Adapters.RecycleviewAdapter;
import com.example.myapplicationtest2.CustomClasses.GeneraCollection;
import com.example.myapplicationtest2.CustomClasses.book;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class genera_display extends AppCompatActivity {

    List<book> check;
    String name;
    TextView textView;
    FloatingActionButton cartButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genera_display);
        getSupportActionBar().hide();
        textView = findViewById(R.id.Display_Genera_Text);
        cartButton = findViewById(R.id.floatingActionButton);

        Intent intent = getIntent();
        try{
            check = intent.getParcelableArrayListExtra("Data");
            name = (String) intent.getExtras().get("name");
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
        }
        textView.setText(name);
        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_Genera_Display);
        RecycleviewAdapter myAdapter = new RecycleviewAdapter(genera_display.this,check);
        myrv.setLayoutManager(new GridLayoutManager(genera_display.this,3));

        myrv.setAdapter(myAdapter);

        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cartIntent = new Intent(genera_display.this,Cart.class);
                startActivity(cartIntent);
            }
        });

    }
}