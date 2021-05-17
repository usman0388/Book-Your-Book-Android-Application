package com.example.myapplicationtest2.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.nfc.cardemulation.CardEmulation;
import android.sax.TextElementListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.myapplicationtest2.CustomClasses.Orders;
import com.example.myapplicationtest2.R;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView text_Cart_Name, text_price;
    public ImageView img_cart_view;

    //private ItemClickListener itemClickListener;


    public void setText_Cart_Name(TextView text_Cart_Name) {
        this.text_Cart_Name = text_Cart_Name;
    }

    public CartViewHolder(View itemView){
        super(itemView);
        text_Cart_Name = itemView.findViewById(R.id.cart_item_name);
        text_price = itemView.findViewById(R.id.cart_item_price);
        img_cart_view = itemView.findViewById(R.id.cart_item_count);

    }

    @Override
    public void onClick(View v) {

    }
}
public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {


    private List<Orders> listData = new ArrayList<>();
    private Context mContext;

    public CartAdapter(List<Orders> listData, Context mContext) {
        this.listData = listData;
        this.mContext = mContext;
    }


    @NonNull
    @NotNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.cart_layout,parent,false);
        return new CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CartViewHolder holder, int position) {

        TextDrawable drawable = TextDrawable.builder()
                .buildRound(""+listData.get(position).getQuantity(), Color.BLACK);
        holder.img_cart_view.setImageDrawable(drawable);

        Locale locale = new Locale("en","GB");
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
        int price = (Integer.parseInt(listData.get(position).getPrice())) * (Integer.parseInt(listData.get(position).getQuantity()));

        holder.text_price.setText(fmt.format(price));
        holder.text_Cart_Name.setText(listData.get(position).getProductName());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}
