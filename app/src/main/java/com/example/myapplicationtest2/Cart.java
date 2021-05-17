package com.example.myapplicationtest2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplicationtest2.Adapters.CartAdapter;
import com.example.myapplicationtest2.CustomClasses.Orders;
import com.example.myapplicationtest2.Database.Database;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Cart extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    TextView textTotal;
    ExtendedFloatingActionButton PlaceOrder;

    List<Orders> cart = new ArrayList<>();

    CartAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().hide();

        //inIT
        recyclerView = findViewById(R.id.listCart);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        textTotal = findViewById(R.id.Total);
        PlaceOrder = findViewById(R.id.PlaceOderButtuon);

        loadListFood();

        PlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Database(getBaseContext()).cleanCart();
                Toast.makeText(Cart.this,"Thank you, Your Order Is Placed", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

    private void loadListFood() {

        cart = new Database(this).getCarts();
        adapter = new CartAdapter(cart,this);
        recyclerView.setAdapter(adapter);

        //Calculate Total Price

        int total = 0;

        for(Orders orders:cart)
            total+= (Integer.parseInt(orders.getPrice()))* (Integer.parseInt(orders.getQuantity()));
        Locale locale = new Locale("en","GB");
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);

        textTotal.setText(fmt.format(total));
    }
}