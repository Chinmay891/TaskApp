package com.example.taskapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    CardView card1,card2,card3;
    ImageView bulb,fan,plug,lamp,gbulb,gfan,gplug,glamp;

    Boolean checkBulb=false,checkFan=false,checkPlug=false,checkLamp=false,checkgBulb=false,checkgFan=false,checkgPlug=false,checkgLamp=false;
    //DB Reference
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference("Device").child("0");
    DatabaseReference ref0 = rootRef.child("Switches").child("0");
    DatabaseReference ref1 = rootRef.child("Switches").child("1");
    DatabaseReference ref2 = rootRef.child("Switches").child("2");
    DatabaseReference ref3 = rootRef.child("Switches").child("3");

    DatabaseReference ref4 = rootRef.child("Switches").child("4");
    DatabaseReference ref5 = rootRef.child("Switches").child("5");
    DatabaseReference ref6 = rootRef.child("Switches").child("6");
    DatabaseReference ref7 = rootRef.child("Switches").child("7");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Get views
        card1 = findViewById(R.id.card1);
        bulb = findViewById(R.id.bulb);
        fan = findViewById(R.id.fan);
        plug = findViewById(R.id.plug);
        lamp = findViewById(R.id.lamp);

        card2 = findViewById(R.id.card2);
        gbulb = findViewById(R.id.gbulb);
        gfan = findViewById(R.id.gfan);
        gplug = findViewById(R.id.gplug);
        glamp = findViewById(R.id.glamp);

        card3 = findViewById(R.id.card3);

        setListeners();
    }


    private void setListeners(){
        card1.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), Card1.class)));
        card2.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), Card2.class)));
        card3.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), Card3.class)));

            bulb.setOnClickListener(v -> {
                if(!checkBulb){
                    HashMap<String, Object> newmap = new HashMap<>();
                    newmap.put("State","1");
                    ref0.updateChildren(newmap);
                    bulb.setImageDrawable(getResources().getDrawable(R.drawable.lbulb));
                    checkBulb=true;
                    Toast.makeText(getApplicationContext(),"State updated in DB",Toast.LENGTH_SHORT).show();
                }
                else{
                    HashMap<String, Object> newmap = new HashMap<>();
                    newmap.put("State","0");
                    ref0.updateChildren(newmap);
                    bulb.setImageDrawable(getResources().getDrawable(R.drawable.bulb));
                    checkBulb=false;
                    Toast.makeText(getApplicationContext(),"State updated in DB",Toast.LENGTH_SHORT).show();
                }

            });

        fan.setOnClickListener(v -> {
            if(!checkFan){
                HashMap<String, Object> newmap = new HashMap<>();
                newmap.put("State","1");
                ref1.updateChildren(newmap);
                fan.setImageDrawable(getResources().getDrawable(R.drawable.lfan));
                checkFan=true;
                Toast.makeText(getApplicationContext(),"State updated in DB",Toast.LENGTH_SHORT).show();

            }
            else{
                HashMap<String, Object> newmap = new HashMap<>();
                newmap.put("State","0");
                ref1.updateChildren(newmap);
                fan.setImageDrawable(getResources().getDrawable(R.drawable.fan));
                checkBulb=false;
                Toast.makeText(getApplicationContext(),"State updated in DB",Toast.LENGTH_SHORT).show();
            }

        });

        plug.setOnClickListener(v -> {
            if(!checkPlug){
                HashMap<String, Object> newmap = new HashMap<>();
                newmap.put("State","1");
                ref2.updateChildren(newmap);
                plug.setImageDrawable(getResources().getDrawable(R.drawable.lplug));
                checkPlug=true;
                Toast.makeText(getApplicationContext(),"State updated in DB",Toast.LENGTH_SHORT).show();
            }
            else{
                HashMap<String, Object> newmap = new HashMap<>();
                newmap.put("State","0");
                ref2.updateChildren(newmap);
                plug.setImageDrawable(getResources().getDrawable(R.drawable.plug));
                checkPlug=false;
                Toast.makeText(getApplicationContext(),"State updated in DB",Toast.LENGTH_SHORT).show();
            }

        });

        lamp.setOnClickListener(v -> {
            if(!checkLamp){
                HashMap<String, Object> newmap = new HashMap<>();
                newmap.put("State","1");
                ref3.updateChildren(newmap);
                lamp.setImageDrawable(getResources().getDrawable(R.drawable.llamp));
                checkLamp=true;
                Toast.makeText(getApplicationContext(),"State updated in DB",Toast.LENGTH_SHORT).show();
            }
            else{
                HashMap<String, Object> newmap = new HashMap<>();
                newmap.put("State","0");
                ref3.updateChildren(newmap);
                lamp.setImageDrawable(getResources().getDrawable(R.drawable.lamp));
                checkLamp=false;
                Toast.makeText(getApplicationContext(),"State updated in DB",Toast.LENGTH_SHORT).show();
            }

        });


        gbulb.setOnClickListener(v -> {
            if(!checkgBulb){
                HashMap<String, Object> newmap = new HashMap<>();
                newmap.put("State","1");
                ref4.updateChildren(newmap);
                gbulb.setImageDrawable(getResources().getDrawable(R.drawable.lbulb));
                checkgBulb=true;
                Toast.makeText(getApplicationContext(),"State updated in DB",Toast.LENGTH_SHORT).show();
            }
            else{
                HashMap<String, Object> newmap = new HashMap<>();
                newmap.put("State","0");
                ref4.updateChildren(newmap);
                gbulb.setImageDrawable(getResources().getDrawable(R.drawable.bulb));
                checkgBulb=false;
                Toast.makeText(getApplicationContext(),"State updated in DB",Toast.LENGTH_SHORT).show();
            }

        });

        gfan.setOnClickListener(v -> {
            if(!checkgFan){
                HashMap<String, Object> newmap = new HashMap<>();
                newmap.put("State","1");
                ref5.updateChildren(newmap);
                gfan.setImageDrawable(getResources().getDrawable(R.drawable.lfan));
                checkgFan=true;
                Toast.makeText(getApplicationContext(),"State updated in DB",Toast.LENGTH_SHORT).show();
            }
            else{
                HashMap<String, Object> newmap = new HashMap<>();
                newmap.put("State","0");
                ref5.updateChildren(newmap);
                gfan.setImageDrawable(getResources().getDrawable(R.drawable.fan));
                checkgFan=false;
                Toast.makeText(getApplicationContext(),"State updated in DB",Toast.LENGTH_SHORT).show();
            }

        });

        gplug.setOnClickListener(v -> {
            if(!checkgPlug){
                HashMap<String, Object> newmap = new HashMap<>();
                newmap.put("State","1");
                ref6.updateChildren(newmap);
                gplug.setImageDrawable(getResources().getDrawable(R.drawable.lplug));
                checkgPlug=true;
                Toast.makeText(getApplicationContext(),"State updated in DB",Toast.LENGTH_SHORT).show();
            }
            else{
                HashMap<String, Object> newmap = new HashMap<>();
                newmap.put("State","0");
                ref6.updateChildren(newmap);
                gplug.setImageDrawable(getResources().getDrawable(R.drawable.plug));
                checkgPlug=false;
                Toast.makeText(getApplicationContext(),"State updated in DB",Toast.LENGTH_SHORT).show();
            }

        });

        glamp.setOnClickListener(v -> {
            if(!checkgLamp){
                HashMap<String, Object> newmap = new HashMap<>();
                newmap.put("State","1");
                ref7.updateChildren(newmap);
                glamp.setImageDrawable(getResources().getDrawable(R.drawable.llamp));
                checkgLamp=true;
                Toast.makeText(getApplicationContext(),"State updated in DB",Toast.LENGTH_SHORT).show();
            }
            else{
                HashMap<String, Object> newmap = new HashMap<>();
                newmap.put("State","0");
                ref7.updateChildren(newmap);
                glamp.setImageDrawable(getResources().getDrawable(R.drawable.lamp));
                checkgLamp=false;
                Toast.makeText(getApplicationContext(),"State updated in DB",Toast.LENGTH_SHORT).show();
            }

        });


    }

}