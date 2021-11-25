package com.example.foodorderingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.foodorderingapp.Models.OrdersModel;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
final static String DBNAME = "database.db";
final static int DBVERSION = 3;

    public DbHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL(
               "create table myorders"+
                       "(id integer primary key autoincrement," +
                       "name text,"+
                       "phone text,"+
                       "price int,"+
                       "image int,"+
                       "description text,"+
                       "foodname text,"+
                       "quantity int)"
       );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP table if exists myorders");
        onCreate(db);
    }

    public boolean insertorder(String name,String phone,int price,int image,String desc,String foodname,int quantity){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        /*
        name - 1
        phone -2
        price -3
        image - 4
        desc - 5
        foodname - 6
        quantity - 7
         */
        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("image",image);
        values.put("description",desc);
        values.put("foodname",foodname);
        values.put("quantity",quantity);
       long id = database.insert("myorders",null,values);
       if (id <=0) {
           return false;
       }
else{
return true;}
       }

      public ArrayList<OrdersModel> getOrders() {

          ArrayList<OrdersModel> orders = new ArrayList<>();
          SQLiteDatabase database = this.getReadableDatabase();
          Cursor cursor = database.rawQuery("Select id,foodname,image,price from myorders", null);
          if (cursor.moveToFirst()) {
              while (cursor.moveToNext()) {
                  OrdersModel model = new OrdersModel();
                  model.setOrderNumber(cursor.getInt(0) + "");
                  model.setSolditemName(cursor.getString(1));
                  model.setOrderImage(cursor.getInt(2));
                  model.setPrice(cursor.getInt(3) + "");
                  orders.add(model);
              }
          }
          cursor.close();
          database.close();
          return orders;
      }

      public Cursor getOrderById(int id){
          SQLiteDatabase database = this.getReadableDatabase();
          Cursor cursor = database.rawQuery("Select * from myorders where id = "+id, null);
          if (cursor != null)
              cursor.moveToFirst();
          return cursor;

      }


    public boolean updateorder(String name,String phone,int price,int image,String desc,String foodname,int quantity,int id){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        /*
        name - 1
        phone -2
        price -3
        image - 4
        desc - 5
        foodname - 6
        quantity - 7
         */
        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("image",image);
        values.put("description",desc);
        values.put("foodname",foodname);
        values.put("quantity",quantity);
        long row = database.update("myorders",values,"id = "+id,null);
        if (row<=0) {
            return false;
        }
        else{
            return true;}
    }
    public  int deleteorder(String id){
        SQLiteDatabase database = getWritableDatabase();
        return database.delete("myorders","id ="+id,null);


    }

    }













