package com.florenciaolivieri.frutiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class Main2Activity_Nivel2 extends AppCompatActivity {

    TextView tv_Nombre, tv_Score, tv_Manzanas;
    private ImageView iv_Vidas, iv_aUno, iv_aDos;
    private EditText et_respuesta;

    String nombre_jugador, string_score, string_vidas;
    int score, numAleatorio_uno, numAleatorio_dos, resultado, vidas;


    //vector para las imagenes dinamicas
    String numero[] = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2__nivel2);
        Toast.makeText(this, R.string.msjToastNivel2, Toast.LENGTH_SHORT).show();

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        tv_Nombre = (TextView) findViewById(R.id.textView_nombre);
        tv_Score = (TextView) findViewById(R.id.textView_score);
        iv_Vidas = (ImageView) findViewById(R.id.imageView_vidas);
        iv_aUno = (ImageView) findViewById(R.id.imgView_aUno);
        iv_aDos = (ImageView) findViewById(R.id.imgView_aDos);

        nombre_jugador = getIntent().getStringExtra("jugador");
        tv_Nombre.setText("Jugador: " + nombre_jugador);

        string_score = getIntent().getStringExtra("score");
        score = Integer.parseInt(string_score);
        tv_Score.setText("Score: " + score);

        string_vidas = getIntent().getStringExtra("vidas");
        vidas = Integer.parseInt(string_vidas);

        switch (vidas) {
            case 3:
                iv_Vidas.setImageResource(R.drawable.tresvidas);
                break;
            case 2:
                iv_Vidas.setImageResource(R.drawable.dosvidas);
                break;
            case 1:
                iv_Vidas.setImageResource(R.drawable.unavida);
                break;
        }


    }
}