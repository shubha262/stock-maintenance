package com.pool.stock__maintainence;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.FirebaseDatabase;

public class Displaydata extends AppCompatActivity {
    RecyclerView recview;
    MyAdapter adapter;

    Button plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaydata);
        ActionBar actionBar;
        actionBar = getSupportActionBar();

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#00BFFF"));

        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomnavigation);
        bottomNavigationView.setSelectedItemId(R.id.display_data);
       bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch(item.getItemId()){
                   case R.id.logout:
                       startActivity(new Intent(getApplicationContext(),Login.class));
                       overridePendingTransition(0,0);
                       return true;
               }
               return false;
           }
       });
        plus=findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent xyz=new Intent(Displaydata.this,AddData.class);
                startActivity(xyz);
            }
        });

        recview=(RecyclerView)findViewById(R.id.recview);
            recview.setLayoutManager(new LinearLayoutManager(
                    this));
            FirebaseRecyclerOptions<RModel> options =
                    new FirebaseRecyclerOptions.Builder<RModel>()
                            .setQuery(FirebaseDatabase.getInstance().getReference().child("Model"), RModel.class)
                            .build();
            adapter=new MyAdapter(options);
            recview.setAdapter(adapter);
        }
        @Override
        protected void onStart() {
            super.onStart();
            adapter.startListening();
        }
        @Override
        protected void onStop() {
            super.onStop();
            adapter.stopListening();
        }






    }


