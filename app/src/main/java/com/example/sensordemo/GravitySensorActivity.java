package com.example.sensordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.DecimalFormat;

import static java.lang.StrictMath.PI;
import static java.lang.StrictMath.atan;
import static java.lang.StrictMath.sqrt;

public class GravitySensorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravity_sensor);
        state = findViewById(R.id.tv_state);
        value = findViewById(R.id.tv_value);
        init();
    }

    TextView state, value;
    SensorManager mSensorManager;
    SensorEventListener mSensorEventListener;

    private void init() {
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        mSensorEventListener = new SensorEventListener() {
            /**
             * 传感器数据发生变化时调用
             * @param event  变化的事件
             */
            @Override
            public void onSensorChanged(SensorEvent event) {
                float x, y, z;
                DecimalFormat df = new DecimalFormat("#0.0");//将返回的float类型的数据格式化保留两位有效数字

                x = Float.parseFloat(df.format(event.values[0]));
                y = Float.parseFloat(df.format(event.values[1]));
                z = Float.parseFloat(df.format(event.values[2]));
                value.setText("x:" + x + "\n" + "y:" + y + "\n" + "z:" + z + "\n");

                if (z > 0) {
                    if (x > 0) {
                        state.setText("手机状态：正面朝上左倾斜");

                    } else {
                        state.setText("手机状态：正面朝上右倾斜");
                    }
                } else {
                    if (x < 0) {
                        state.setText("手机状态：背面朝上左倾斜");
                    } else {
                        state.setText("手机状态：背面朝上右倾斜");
                    }
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        mSensorManager.registerListener(mSensorEventListener, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSensorManager.unregisterListener(mSensorEventListener);
    }
}