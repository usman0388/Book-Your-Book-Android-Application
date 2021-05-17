package com.example.myapplicationtest2.CustomClasses;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class book extends ArrayList<Parcelable> implements Parcelable {
    private int id;
    private String title;
    private String Thumbnail_URL;
    private float rating;
    private String Description;
    private int price;
    private String Author;
    private ArrayList<String> BookGenre;

    public book(int id, String title, String thumbnail_URL, float rating, String description, int price, String author, ArrayList<String> genre) {
        this.id = id;
        this.title = title;
        Thumbnail_URL = thumbnail_URL;
        this.rating = rating;
        Description = description;
        this.price = price;
        Author = author;
        this.BookGenre = genre;
    }

    protected book(Parcel in) {
        id = in.readInt();
        title = in.readString();
        Thumbnail_URL = in.readString();
        rating = in.readFloat();
        Description = in.readString();
        price = in.readInt();
        Author = in.readString();
        BookGenre = in.createStringArrayList();
    }

    public static final Creator<book> CREATOR = new Creator<book>() {
        @Override
        public book createFromParcel(Parcel in) {
            return new book(in);
        }

        @Override
        public book[] newArray(int size) {
            return new book[size];
        }
    };

    public Boolean checkGenre(String name){

        for(int i=0;i<this.BookGenre.size();i++){
            if(this.BookGenre.get(i).equals(name)){
                return true;
            }
        }

        return false;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public ArrayList<String> getGenre() {
        return this.BookGenre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.BookGenre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail_URL() {
        return Thumbnail_URL;
    }

    public void setThumbnail_URL(String thumbnail_URL) {
        Thumbnail_URL = thumbnail_URL;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(Thumbnail_URL);
        dest.writeFloat(rating);
        dest.writeString(Description);
        dest.writeInt(price);
        dest.writeString(Author);
        dest.writeStringList(BookGenre);
    }
}
