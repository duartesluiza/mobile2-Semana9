package com.example.semana9_jogo;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    Sensor accelerometer;
    SensorManager sensorManager;
    float sensorX;
    int nesp = 0;
    String espaco= "";
    String tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener((SensorEventListener) this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        sensorX= event.values[0];

        EditText tx =(EditText) findViewById(R.id.eixoX);

        if(sensorX > 1 && nesp < 75){
            nesp += 1;
        }
        if(sensorX < 0 && nesp > 1){
            nesp -= 1;
        }
        espaco = "";

        for (int i=0; i<nesp; i++){
            espaco = espaco + " ";
        }


        tela = "";
        tela= "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
        tx.setText(tela+espaco+"A");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}