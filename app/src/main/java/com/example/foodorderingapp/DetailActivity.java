package com.example.foodorderingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.foodorderingapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        DbHelper helper = new DbHelper(this);
        if (getIntent().getIntExtra("type", 0) == 1) {

            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            String foodname = getIntent().getStringExtra("name");
            final int quantity =  Integer.parseInt(getIntent().getStringExtra("quant"));
            String disc = getIntent().getStringExtra("disc");


            binding.DetailImage.setImageResource(image);
            binding.detailname.setText(foodname);
            binding.detailprice.setText(String.format("%d", price));
            binding.detaildescription.setText(disc);
            binding.increment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int count = Integer.parseInt(String.valueOf(binding.quantity.getText()));
                    count++;
                    binding.quantity.setText(""+count);
                }
            });
            binding.decrement.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int count = Integer.parseInt(String.valueOf(binding.quantity.getText()));
                   if(count == 1){
                       binding.quantity.setText("1");
                   }
                   else{
                       count -= 1;
                       binding.quantity.setText(""+count);
                   }
                }
            });

            binding.insertbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isInserted = helper.insertorder(binding.username.getText().toString(), binding.userphone.getText().toString(), price, image, disc, foodname, Integer.parseInt(binding.quantity.getText().toString()));
                    if (isInserted) {
                        Toast.makeText(DetailActivity.this, "Your order is placed", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DetailActivity.this,MainActivity.class);
                        DetailActivity.this.startActivity(intent);

                    } else {
                        Toast.makeText(DetailActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

        else{

            int id = getIntent().getIntExtra("id",0);
            Cursor cursor = helper.getOrderById(id);
          final  int image = cursor.getInt(4);
          final int quantity = cursor.getInt(7);
            binding.DetailImage.setImageResource(cursor.getInt(4));
            binding.detailname.setText(cursor.getString(6));
            binding.detailprice.setText(String.format("%d", cursor.getInt(3)));
            binding.detaildescription.setText(cursor.getString(5));
            binding.username.setText(cursor.getString(1));
            binding.userphone.setText(cursor.getString(2));
            binding.insertbtn.setText("Update Order");
            binding.increment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int count = Integer.parseInt(String.valueOf(binding.quantity.getText()));
                    count++;
                    binding.quantity.setText(""+count);
                }
            });
            binding.decrement.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int count = Integer.parseInt(String.valueOf(binding.quantity.getText()));
                    if(count == 1){
                        binding.quantity.setText("1");
                    }
                    else{
                        count -= 1;
                        binding.quantity.setText(""+count);
                    }
                }
            });
            binding.insertbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   boolean isUpdated =   helper.updateorder(binding.username.getText().toString(),
                              binding.userphone.getText().toString(),
                              Integer.parseInt(binding.detailprice.getText().toString()),image,
                              binding.detaildescription.getText().toString(),binding.detailname.getText().toString(),Integer.parseInt(binding.quantity.getText().toString()),id);
                   if(isUpdated){
                       Toast.makeText(DetailActivity.this, "Your Order is Updated", Toast.LENGTH_SHORT).show();
                       Intent intent = new Intent(DetailActivity.this,MainActivity.class);
                       DetailActivity.this.startActivity(intent);

                   }
                   else
                   {
                       Toast.makeText(DetailActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                   }
                }

            });

        }
// when order is incremented


    }


}


