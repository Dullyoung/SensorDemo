package com.example.sensordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button mListBtn,mGravityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mListBtn = findViewById(R.id.list_btn);
        mListBtn.setOnClickListener(this);
        mGravityBtn=findViewById(R.id.gravity_btn);
        mGravityBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==mListBtn){
            startActivity(new Intent(this,SensorListActivity.class));
        }
        if (v==mGravityBtn){
            startActivity(new Intent(this, GravitySensorActivity.class));
        }
    }
}