package com.example.myapplicationtest2.Adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationtest2.CustomClasses.Orders;
import com.example.myapplicationtest2.CustomClasses.book;
import com.example.myapplicationtest2.Database.Database;
import com.example.myapplicationtest2.GlideApp;
import com.example.myapplicationtest2.R;
import com.example.myapplicationtest2.clickedActivity;

import java.util.ArrayList;
import java.util.List;

public class RecycleviewAdapter extends RecyclerView.Adapter<RecycleviewAdapter.MyViewHolder> {

    private Context mContext;
    private List<book> mData;

    public RecycleviewAdapter(Context mContext, List<book> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview,parent,false);
        return new MyViewHolder(view);
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,final int position) {
        holder.title.setText(mData.get(position).getTitle());
        holder.price.setText("£"+ mData.get(position).getPrice());
        GlideApp.with(mContext)
                .load(mData.get(position).getThumbnail_URL())
                .into(holder.img_Url);
        holder.rating.setText(String.valueOf(mData.get(position).getRating()));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, clickedActivity.class);
                intent.putParcelableArrayListExtra("Data", (ArrayList<? extends Parcelable>) mData);
                intent.putExtra("pos",position);
                mContext.startActivity(intent);
            }
        });
        holder.CartImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Database(mContext).addToCart(new Orders(
                        String.valueOf(mData.get(position).getId()),
                        mData.get(position).getTitle(),
                        "1",
                        String.valueOf(mData.get(position).getPrice())
                ));

                Toast.makeText(mContext,"Item Added to Cart",Toast.LENGTH_LONG).show();
            }
        });

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView price;
        TextView rating;
        ImageView img_Url;
        CardView cardView;
        ImageView CartImg;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title_id) ;
            img_Url = (ImageView) itemView.findViewById(R.id.cardView_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);
            price = itemView.findViewById(R.id.price);
            rating = itemView.findViewById(R.id.rating);
            CartImg = itemView.findViewById(R.id.card_id_addCart);
        }
    }
}
