package com.example.myapplicationtest2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplicationtest2.Remote.ApiClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class secondActivity extends AppCompatActivity {

    private List<ImageResponse> imageResponseList = new ArrayList<>();

    GridView gridView;
    ProgressBar progressBar;

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabItem tab1, tab2;
    public PagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setExitTransition(new Explode());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().hide();

        //initializing variables
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        tab1 = findViewById(R.id.tab1);
        tab2 = findViewById(R.id.tab2);


        //Camera Button
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cartIntent = new Intent(secondActivity.this,Cart.class);
                startActivity(cartIntent);
            }
        });



        //View Pager Implementation
        pagerAdapter = new com.example.myapplicationtest2.Adapters.PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setPageTransformer(true,new DepthPageTransformer());

        tabLayout.setOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


//        getAllImages();
/*
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Check if we're running on Android 5.0 or higher
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Log.i("ANIM", "Fade called");
                    Intent intent = new Intent(getApplicationContext(),clickedActivity.class);
                    intent.putExtra("data",imageResponseList.get(position));

                    startActivity(intent,
                            ActivityOptions.makeSceneTransitionAnimation(secondActivity.this).toBundle());

                    // Apply activity transition
                } else {
                    // Swap without transition
                    startActivity(new Intent(getApplicationContext(),clickedActivity.class)
                            .putExtra("data",imageResponseList.get(position)));
                }
            }
        });*/
    }


    public void getAllImages(){

        Call<List<ImageResponse>> imageResponse = ApiClient.getInterface().getAllImages();

        imageResponse.enqueue(new Callback<List<ImageResponse>>() {
            @Override
            public void onResponse(Call<List<ImageResponse>> call, Response<List<ImageResponse>> response) {

                if(response.isSuccessful()){
                    String message = "Request Successful...";
                    Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();

                    imageResponseList = response.body();
                    CustomAdapter customAdapter = new CustomAdapter(imageResponseList,secondActivity.this);

                    gridView.setAdapter(customAdapter);
                    progressBar.setVisibility(View.GONE);
                    gridView.setVisibility(View.VISIBLE);

                }else {
                    String message = "An error occurred try again later...";
                    Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<List<ImageResponse>> call, Throwable t) {
                String mess = t.getLocalizedMessage();
                Toast.makeText(getApplicationContext(),mess,Toast.LENGTH_LONG).show();
            }
        });

    }

    public class CustomAdapter extends BaseAdapter{
        private List<ImageResponse> imageResponseList;
        private Context context;
        private LayoutInflater layoutInflater;

        public CustomAdapter(List<ImageResponse> imageResponseList, Context context) {
            this.imageResponseList = imageResponseList;
            this.context = context;
            this.layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return imageResponseList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView == null){
                convertView = layoutInflater.inflate(R.layout.row_grid,parent,false);

            }

            ImageView imageView = convertView.findViewById(R.id.gridImage);
            TextView textView = convertView.findViewById(R.id.newText);

            textView.setText(imageResponseList.get(position).getName());

            GlideApp.with(context)
                    .load(imageResponseList.get(position).getUrl())
                    .into(imageView);
            return convertView;
        }
    }
}