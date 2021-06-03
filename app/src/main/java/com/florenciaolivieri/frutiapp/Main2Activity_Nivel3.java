package com.florenciaolivieri.frutiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class Main2Activity_Nivel3 extends AppCompatActivity {

    TextView tv_Jugador, tv_Score, tv_Manzanas;
    EditText et_Resultado;
    ImageView iv_NumAleatorio1, iv_NumAleatorio2, iv_Manzanas;

    String nombre_jugador, string_Score, string_Vidas;
    int score, numAleatorio_Uno, numAleatorio_Dos, resultado, vidas;

    //vector para las imagenes dinamicas
    String numero[] = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2__nivel3);
        Toast.makeText(this, R.string.msjToastNivel3, Toast.LENGTH_SHORT).show();

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        tv_Jugador = (TextView) findViewById(R.id.tv_Jugador);
        tv_Score = (TextView) findViewById(R.id.tv_Score);
        tv_Manzanas = (TextView) findViewById(R.id.tv_Manzanas);
        et_Resultado = (EditText) findViewById(R.id.edt_Resultado);
        iv_NumAleatorio1 = (ImageView) findViewById(R.id.imgView_AUno);
        iv_NumAleatorio2 = (ImageView) findViewById(R.id.imgView_ADos);
        iv_Manzanas = (ImageView) findViewById(R.id.iv_Manzanas);


        nombre_jugador = getIntent().getStringExtra("nombre_jugador");
        tv_Jugador.setText("Jugador: " + nombre_jugador);

        string_Score = getIntent().getStringExtra("score");
        score = Integer.parseInt(string_Score);
        tv_Jugador.setText("Score: " + score);

        string_Vidas = getIntent().getStringExtra("vidas");
        vidas = Integer.parseInt(string_Vidas);

        switch (vidas) {
            case 3:
                iv_Manzanas.setImageResource(R.drawable.tresvidas);
                break;
            case 2:
                iv_Manzanas.setImageResource(R.drawable.dosvidas);
                break;
            case 1:
                iv_Manzanas.setImageResource(R.drawable.unavida);
                break;

        }


    }
}