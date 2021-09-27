package com.example.taskapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Card1 extends AppCompatActivity {
    ImageView lock;
    String colour="Orange";
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference("Device").child("0");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card1);
        lock = findViewById(R.id.lock);
        setListeners();
    }

    private void setListeners() {
        lock.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if(colour=="Orange"){
                    HashMap<String,Object> map = new HashMap<>();
                    map.put("Lock","Green");
                    rootRef.updateChildren(map);
                    lock.setImageDrawable(getResources().getDrawable(R.drawable.glock));
                    colour="Green";
                    Toast.makeText(getApplicationContext(),"Colour updated to Green in DB",Toast.LENGTH_SHORT).show();
                }
                else if(colour=="Green"){
                    HashMap<String,Object> map = new HashMap<>();
                    map.put("Lock","Grey");
                    rootRef.updateChildren(map);
                    colour="Grey";
                    Toast.makeText(getApplicationContext(),"Colour updated to Grey in DB",Toast.LENGTH_SHORT).show();
                }
                else if(colour=="Grey"){
                    HashMap<String,Object> map = new HashMap<>();
                    map.put("Lock","Orange");
                    rootRef.updateChildren(map);
                    lock.setImageDrawable(getResources().getDrawable(R.drawable.lock));
                    colour="Orange";
                    Toast.makeText(getApplicationContext(),"Colour updated to Orange in DB",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}