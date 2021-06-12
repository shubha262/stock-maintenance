package com.pool.stock__maintainence;



import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText Username,pass;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar;
        actionBar = getSupportActionBar();


        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#00BFFF"));

        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);

        Username=findViewById(R.id.username);
        pass=findViewById(R.id.pass);

        submit=findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Username.getText().toString().equals("Admin")&& pass.getText().toString().equals("12345")){
                    Intent abc=new Intent(Login.this,Displaydata.class);
                    startActivity(abc);
                    finish();
                }
                else{
                    Toast.makeText(Login.this,"Invalid Username/Password",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}