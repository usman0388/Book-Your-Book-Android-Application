package com.example.myapplicationtest2.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.myapplicationtest2.CustomClasses.Orders;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteAssetHelper {
    private static final String DB_NAME = "bookDatabase.db";
    private static final int DB_VER = 1;


    public Database(Context context) {
        super(context, DB_NAME, null,DB_VER);
    }

    public List<Orders> getCarts(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"ProductId","ProductName", "Quantity", "Price"};
        String sqlTable = "OrderDetail";

        qb.setTables(sqlTable);

        Cursor c = qb.query(db, sqlSelect,null,null,null,null,null);

        final List<Orders> result = new ArrayList<>();
        if(c.moveToFirst()){
            do{
                result.add(new Orders(c.getString(c.getColumnIndex("ProductId")),
                        c.getString(c.getColumnIndex("ProductName")),
                        c.getString(c.getColumnIndex("Quantity")),
                        c.getString(c.getColumnIndex("Price"))
                ));
            }while (c.moveToNext());
        }
        return result;
    }


    public void addToCart(Orders orders){

        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("INSERT INTO OrderDetail(ProductId,ProductName,Quantity,Price) VALUES('%s','%s','%s','%s');",
                orders.getProductId(),
                orders.getProductName(),
                orders.getQuantity(),
                orders.getPrice());

        db.execSQL(query);
    }


    public void cleanCart(){

        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("DELETE FROM OrderDetail");

        db.execSQL(query);
    }
}
