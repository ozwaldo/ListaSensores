package com.example.listasensores;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        StringBuilder sensorTexto = new StringBuilder();

        for (Sensor sensorActual : sensorList) {
            sensorTexto.append(sensorActual.getName()).append(
                    System.getProperty("line.separator"));
        }

        TextView textView = (TextView) findViewById(R.id.lista_sensores);
        textView.setText(sensorTexto);
    }
}
