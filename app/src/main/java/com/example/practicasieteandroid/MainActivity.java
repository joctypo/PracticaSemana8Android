package com.example.practicasieteandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private Button recoger,izquierda,derecha,arriba,abajo;
    private TCPSingelton tcp;
    private String accionesboton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recoger = findViewById(R.id.recoger);
        izquierda = findViewById(R.id.izquierda);
        derecha = findViewById(R.id.derecha);
        arriba = findViewById(R.id.arriba);
        abajo = findViewById(R.id.abajo);
        tcp = TCPSingelton.getInstance();

        recoger.setOnClickListener(
                v -> {

                    tcp.accion("CATCHIT");

                }

        );
        izquierda.setOnTouchListener(this);
        derecha.setOnTouchListener(this);
        arriba.setOnTouchListener(this);
        abajo.setOnTouchListener(this);



    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()){
            case R.id.arriba:
                accionesboton="UP";
                break;


            case R.id.abajo:
                accionesboton="DOWN";
                break;



            case R.id.izquierda:
                accionesboton="LEFT";
                break;



            case R.id.derecha:
                accionesboton="RIGHT";
                break;


        }

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
                accionesboton=accionesboton+"START";
                tcp.accion(accionesboton);
                break;

            case MotionEvent.ACTION_UP:
                accionesboton=accionesboton+"STOP";
                tcp.accion(accionesboton);
                break;

        }
        return true;
    }
}