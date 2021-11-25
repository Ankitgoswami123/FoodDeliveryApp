package com.example.foodorderingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.foodorderingapp.Adapters.MainAdapter;
import com.example.foodorderingapp.Models.MainModel;
import com.example.foodorderingapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.a,"Idli","50","This is best idli with great samdhar andc chatni"));
        list.add(new MainModel(R.drawable.b,"Chhena Mithai","100","This is best Sweet with Pura bhara hua chhena "));
        list.add(new MainModel(R.drawable.c,"Cake","400","This is best black forest cake  with great tasty cream"));
        list.add(new MainModel(R.drawable.d,"Kaju Barfi","50","This is best Kaju barfi  with great original kaju and cream"));
        list.add(new MainModel(R.drawable.e,"Dosa","45","This is best masala dosa with great samdhar andc chatni"));
        list.add(new MainModel(R.drawable.f,"Chandrakala","55","This is best chandra kala with great with sweet inside it"));
        list.add(new MainModel(R.drawable.g,"Palao","150","This is best Palao with great vegetables toping"));
        list.add(new MainModel(R.drawable.h,"Noodles","100","This is best Noodles with great tomato and chilli sauce"));
        MainAdapter adapter = new MainAdapter(list,this);
        binding.recyclerview.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
            startActivity(new Intent(MainActivity.this,OrderActivity.class));
            break;

        }

        return super.onOptionsItemSelected(item);
    }
}