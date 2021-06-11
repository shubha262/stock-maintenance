package com.pool.stock__maintainence;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Define ActionBar object

        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                Intent i = new Intent(MainActivity.this, Login.class);
                startActivity(i);
                finish(); } }, 3000);
    }
}