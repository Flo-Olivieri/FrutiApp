package com.florenciaolivieri.frutiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class Main2Activity_Nivel3 extends AppCompatActivity {

    TextView tv_Jugador, tv_Score, tv_Manzanas;
    EditText et_Resultado;
    ImageView iv_NumAleatorio1, iv_NumAleatorio2, iv_Manzanas;

    String nombre_jugador, string_score, string_Vidas;
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

        string_score = getIntent().getStringExtra("score");
        score = Integer.parseInt(string_score);
        tv_Score.setText("Score: " + string_score);

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

        NumAleatorio();
    }

    public void Comparar(View view) {
        String respuesta = et_Resultado.getText().toString();

        if (!respuesta.equals("")) {
            int respuesta_jugador = Integer.parseInt(respuesta);
            if (respuesta_jugador == resultado) {
                Toast.makeText(this, "Respuesta correcta!", Toast.LENGTH_SHORT).show();
                score++;
                tv_Score.setText("Score: " + score);
                et_Resultado.setText("");

            } else {
                vidas--;
                switch (vidas) {
                    case 3:
                        iv_Manzanas.setImageResource(R.drawable.tresvidas);
                        break;
                    case 2:
                        Toast.makeText(this, "Respuesta incorrecta! Te quedan 2 manzanas", Toast.LENGTH_SHORT).show();
                        iv_Manzanas.setImageResource(R.drawable.dosvidas);
                        break;
                    case 1:
                        Toast.makeText(this, "Respuesta incorrecta! Te queda 1 manzana", Toast.LENGTH_SHORT).show();
                        iv_Manzanas.setImageResource(R.drawable.unavida);
                        break;
                    case 0:
                        Toast.makeText(this, "Respuesta incorrecta! Te quedaste sin manzanas. GAME OVER!!", Toast.LENGTH_LONG).show();
                        tv_Manzanas.setText("Manzanas: " + vidas);
                        iv_Manzanas.setImageResource(R.drawable.fondoet);
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                        break;
                }
                et_Resultado.setText("");
            }
            NumAleatorio();
        } else {
            Toast.makeText(this, R.string.msjToastBtnComprobar, Toast.LENGTH_SHORT).show();

        }
    }

    public void NumAleatorio() {
        if (score <= 15) {

            numAleatorio_Uno = (int) (Math.random() * 10);
            numAleatorio_Dos = (int) (Math.random() * 10);

            resultado = numAleatorio_Uno - numAleatorio_Dos;
            if (resultado >= 0) {
                for (int i = 0; i < numero.length; i++) {
                    int id = getResources().getIdentifier(numero[i], "drawable", getPackageName());
                    if (numAleatorio_Uno == i) {
                        iv_NumAleatorio1.setImageResource(id);
                    }
                    if (numAleatorio_Dos == i) {
                        iv_NumAleatorio2.setImageResource(id);
                    }

                }

            } else {
                NumAleatorio();
            }


        } else {
            Toast.makeText(this, R.string.msjToastNivelAprobado, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Main2Activity_Nivel4.class);
        }
    }
}