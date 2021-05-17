package com.example.myapplicationtest2.Adapters;

import android.content.Context;
import android.content.Intent;
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

import com.example.myapplicationtest2.CustomClasses.GeneraCollection;
import com.example.myapplicationtest2.CustomClasses.book;
import com.example.myapplicationtest2.R;
import com.example.myapplicationtest2.clickedActivity;
import com.example.myapplicationtest2.genera_display;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GeneraListViewAdapter extends RecyclerView.Adapter<GeneraListViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<book> mData;
    String []generaList = {"Science Fiction","Fantasy","Fiction","Horror","Young Adult","Historical","Adventure", "Time Travel", "Westerns", "Romance","New Adult","Paranormal","Magic"};
    ArrayList<Integer> arrayList= new ArrayList<>();
    ArrayList<GeneraCollection> genreList = new ArrayList<>();
    public GeneraListViewAdapter(Context mContext, List<book> mData) {
        this.mContext = mContext;
        this.mData = mData;
        
        populateArray();
    }

    private void populateArray() {
        List<book> tempBooks = new ArrayList<>();
        for(int i =0; i< generaList.length; i++){
            for (int j = 0; j<mData.size();j++){
                if(mData.get(j).checkGenre(generaList[i])){
                    tempBooks.add(new book(mData.get(j).getId(),
                            mData.get(j).getTitle(),
                            mData.get(j).getThumbnail_URL(),
                            mData.get(j).getRating(),
                            mData.get(j).getDescription(),
                            mData.get(j).getPrice(),
                            mData.get(j).getAuthor(),
                            mData.get(j).getGenre()));
                }
            }
            if (tempBooks.size()>0){
                arrayList.add(tempBooks.size());
                genreList.add(new GeneraCollection(generaList[i],tempBooks));
            }
            tempBooks = new ArrayList<>();
        }
    }


    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.genere_card_view,parent,false);
        return new GeneraListViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        holder.title_g.setText(generaList[position]);//fix this later
        holder.quantity.setText(arrayList.get(position)+" Items");//Fix this later
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, genera_display.class);

                intent.putParcelableArrayListExtra("Data", (ArrayList<? extends Parcelable>) genreList.get(position).getGeneraCollection());
                intent.putExtra("name",generaList[position]);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return generaList.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title_g;
        TextView quantity;
        CardView cardView;
        public MyViewHolder(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardviewGenera_id);
            title_g = (TextView) itemView.findViewById(R.id.card_genere_textView);
            quantity = (TextView) itemView.findViewById(R.id.card_itemNo_textView);
        }
    }
}
