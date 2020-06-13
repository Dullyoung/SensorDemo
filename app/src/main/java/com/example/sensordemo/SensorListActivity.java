package com.example.sensordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class SensorListActivity extends AppCompatActivity {
    String TAG="aaaa";
    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);
        mTextView=findViewById(R.id.list_text);
        init();
    }

    private void init() {
        String info="";
        SensorManager mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> mSensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        info+="当前设备共有"+mSensorList.size()+"个传感器:\n";
        for (Sensor mSensor:mSensorList){
            info+=mSensor.getName()+"\n";
        }
         mTextView.setText(info);

    }
}