package com.example.myapplicationtest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplicationtest2.CustomClasses.Orders;
import com.example.myapplicationtest2.CustomClasses.book;
import com.example.myapplicationtest2.Database.Database;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class clickedActivity extends AppCompatActivity {

    int pos;
    List<book> check;
    ImageView imageView;
    TextView Title;
    TextView author;
    TextView Price;
    TextView Rating;
    Button addCart;
    TextView desc;
    FloatingActionButton cartBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicked);
        getSupportActionBar().hide();
        imageView = findViewById(R.id.imageSelected);
        Title = findViewById(R.id.selectedName);
        author = findViewById(R.id.AuthorName);
        Price = findViewById(R.id.textView2);
        Rating = findViewById(R.id.RatingShow);
        addCart = findViewById(R.id.Add_to_Cart_Selected);
        desc = findViewById(R.id.textDesc);
        cartBtn = findViewById(R.id.floatingActionButton_SelectedBook);
        Intent intent = getIntent();

        try{
            check = intent.getParcelableArrayListExtra("Data");
            pos = intent.getExtras().getInt("pos");
            //Setting Data
            GlideApp.with(clickedActivity.this)
                    .load(check.get(pos).getThumbnail_URL())
                    .into(imageView);
            Title.setText(check.get(pos).getTitle());
            author.setText(check.get(pos).getAuthor());
            Price.setText("Price: £"+check.get(pos).getPrice());
            Rating.setText(String.valueOf(check.get(pos).getRating()));
            desc.setText(check.get(pos).getDescription());
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
        }

        addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Database(getBaseContext()).addToCart(new Orders(
                        String.valueOf(check.get(pos).getId()),
                        check.get(pos).getTitle(),
                        "1",
                        String.valueOf(check.get(pos).getPrice())
                ));

                Toast.makeText(clickedActivity.this,"Item Added to Cart",Toast.LENGTH_LONG).show();
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cartIntent = new Intent(clickedActivity.this,Cart.class);
                startActivity(cartIntent);
            }
        });
    }
}