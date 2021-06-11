package com.pool.stock__maintainence;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddData extends AppCompatActivity {
    TextView textdate;
    EditText name,phone,address,quantity,rate,total,gst,duedate;
    RadioGroup rg;
    Button store;
    RadioButton radioButton,r1,r2,r3;
    String s="0",due="";
    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        ActionBar actionBar;
        actionBar = getSupportActionBar();


        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#00BFFF"));

        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);
        db= FirebaseDatabase.getInstance().getReference("Model");
        textdate=findViewById(R.id.date);


        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone);
        address=findViewById(R.id.address);
        quantity=findViewById(R.id.Quantity);
        total=findViewById(R.id.total);
        gst=findViewById(R.id.gst);
        rate=findViewById(R.id.rate);
        r1=findViewById(R.id.Paid);
        r2=findViewById(R.id.Notpaid);
        r3=findViewById(R.id.Pending);
        duedate=findViewById(R.id.Duedate);
        rg=findViewById(R.id.rg);
        store=findViewById(R.id.save);
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveRecord();
            }
        });
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        String currentDateandTime = sdf.format(new Date());
        textdate.setText(currentDateandTime);


    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.Paid:
                if (checked) {
                    // Pirates are the best
                    duedate.setVisibility(View.INVISIBLE);
                    s = r1.getText().toString();
                    break;
                }
            case R.id.Notpaid:
                if (checked)
                    // Ninjas rule
                {
                    duedate.setVisibility(View.INVISIBLE);
                    s = r2.getText().toString();
                    break;
                }
            case R.id.Pending:
                if(checked) {
                    duedate.setVisibility(View.VISIBLE);
                    String k=r3.getText().toString();
                    String due=duedate.getText().toString();

                    s=k ;
                    break;
                }

        }
    }



    public void saveRecord(){
        String currentDate=textdate.getText().toString();
        String rname=name.getText().toString();
        String rphone=phone.getText().toString();
        String raddress=address.getText().toString();
        String rquantity=quantity.getText().toString();
        String rrate=rate.getText().toString();
        String rtotal=total.getText().toString();
        String rgst=gst.getText().toString();
       due=duedate.getText().toString();
        String rduedate=s+due;
            if(!TextUtils.isEmpty(currentDate) &&!TextUtils.isEmpty(rphone) && !TextUtils.isEmpty(rname) && !TextUtils.isEmpty(raddress) &&!TextUtils.isEmpty(rquantity) && !TextUtils.isEmpty(rrate) && !TextUtils.isEmpty(rtotal
            ) &&  !TextUtils.isEmpty(rgst) && !TextUtils.isEmpty(rduedate))
            {
                String did = db.push().getKey();
                RModel vmodel = new RModel(currentDate,rname,rphone,raddress,rquantity,rrate,rtotal,rgst,rduedate);
                db.child(did).setValue(vmodel);
                Toast.makeText(this,"Registered",Toast.LENGTH_LONG).show();
                Intent i=new Intent(AddData.this,Displaydata.class);
                startActivity(i);



        }









    }

}
