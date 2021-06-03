
package com.florenciaolivieri.frutiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        tv_Manzanas = (TextView) findViewById(R.id.textView_manzanas);
        tv_Score = (TextView) findViewById(R.id.textView_score);
        iv_Vidas = (ImageView) findViewById(R.id.imageView_vidas);
        iv_aUno = (ImageView) findViewById(R.id.imgView_aUno);
        iv_aDos = (ImageView) findViewById(R.id.imgView_aDos);
        et_respuesta = (EditText) findViewById(R.id.editText_Resultado);

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

        NumAleatorio();
    }

    /* Método para comprobar que las respuetas sean correctas
     * El score no puede superar 10 */
    public void Comparar(View view) {
        String respuesta = et_respuesta.getText().toString();

        if (!respuesta.equals("")) {
            int respuesta_jugador = Integer.parseInt(respuesta);
            if (respuesta_jugador == resultado) {
                Toast.makeText(this, "Respuesta correcta!", Toast.LENGTH_SHORT).show();
                score++;
                tv_Score.setText("Score: " + score);
                et_respuesta.setText("");

            } else {
                vidas--;
                switch (vidas) {
                    case 3:
                        iv_Vidas.setImageResource(R.drawable.tresvidas);
                        break;
                    case 2:
                        Toast.makeText(this, "Respuesta incorrecta! Te quedan 2 manzanas", Toast.LENGTH_SHORT).show();
                        iv_Vidas.setImageResource(R.drawable.dosvidas);
                        break;
                    case 1:
                        Toast.makeText(this, "Respuesta incorrecta! Te queda 1 manzana", Toast.LENGTH_SHORT).show();
                        iv_Vidas.setImageResource(R.drawable.unavida);
                        break;
                    case 0:
                        Toast.makeText(this, "Respuesta incorrecta! Te quedaste sin manzanas. GAME OVER!!", Toast.LENGTH_LONG).show();
                        tv_Manzanas.setText("Manzanas: " + vidas);
                        iv_Vidas.setImageResource(R.drawable.fondoet);
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                        break;
                }
                et_respuesta.setText("");
            }
            NumAleatorio();
        } else {
            Toast.makeText(this, R.string.msjToastBtnComprobar, Toast.LENGTH_SHORT).show();

        }
    }

    public void NumAleatorio() {
        if (score <= 19) {
            numAleatorio_uno = (int) (Math.random() * 10);
            numAleatorio_dos = (int) (Math.random() * 10);
            resultado = numAleatorio_uno + numAleatorio_dos;

            if (resultado <= 10) {
                for (int i = 0; i < numero.length; i++) {
                    int id = getResources().getIdentifier(numero[i], "drawable", getPackageName());
                    if (numAleatorio_uno == i) {
                        iv_aUno.setImageResource(id);
                    }
                    if (numAleatorio_dos == i) {
                        iv_aDos.setImageResource(id);
                    }

                }

            } else {
                NumAleatorio();
            }
        } else {
            Toast.makeText(this, R.string.msjToastNivelAprobado, Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Main2Activity_Nivel3.class);
            i.putExtra("nombre_jugador", nombre_jugador);
            i.putExtra("score", score);
            i.putExtra("vidas", vidas);
            startActivity(i);
        }
    }


}