
package com.florenciaolivieri.frutiapp;

import androidx.appcompat.app.ActionBar;
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

public class Main2Activity_Nivel1 extends AppCompatActivity {

    private TextView tv_nombre, tv_score, tv_manzanas;
    private ImageView iv_vidas, iv_aUno, iv_aDos;
    private EditText et_respuesta;

    int score, numAleatorio_uno, numAleatorio_dos, resultado, vidas = 3;
    String nombre_jugador, string_score, string_vidas;

    //vector para las imagenes dinamicas
    String numero[] = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2__nivel1);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        Toast.makeText(this, R.string.msjToastNivel1, Toast.LENGTH_LONG).show();

        tv_nombre = (TextView) findViewById(R.id.textview_nombre);
        tv_score = (TextView) findViewById(R.id.textview_score);
        tv_manzanas = (TextView) findViewById(R.id.textView_manzanas);
        iv_vidas = (ImageView) findViewById(R.id.imageview_vidas);
        iv_aUno = (ImageView) findViewById(R.id.imgview_aUno);
        iv_aDos = (ImageView) findViewById(R.id.imgview_aDos);
        et_respuesta = (EditText) findViewById(R.id.editText_resultado);

        nombre_jugador = getIntent().getStringExtra("jugador");
        tv_nombre.setText("Jugador: " + nombre_jugador);

        NumAleatorio();


    }

    /* Método para comprobar que las respuetas sean correctas
     * El score no puede superar 10 */
    public void Comparar(View view) {
        String respuesta = et_respuesta.getText().toString();

        if (!respuesta.equals("")) {
            int respuesta_jugador = Integer.parseInt(respuesta);
            if (resultado == respuesta_jugador) {
                score++;
                Toast.makeText(this, "Respuesta correcta! Continua así", Toast.LENGTH_SHORT).show();
                tv_score.setText("Score: " + score);
                et_respuesta.setText("");

            } else {
                //Toast.makeText(this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
                vidas--;
                switch (vidas) {
                    case 3:
                        iv_vidas.setImageResource(R.drawable.tresvidas);
                        break;
                    case 2:
                        Toast.makeText(this, "Respuesta incorrecta! Te quedan 2 vidas", Toast.LENGTH_SHORT).show();
                        iv_vidas.setImageResource(R.drawable.dosvidas);
                        break;
                    case 1:
                        Toast.makeText(this, "Respuesta incorrecta! Te queda 1 vida", Toast.LENGTH_SHORT).show();
                        iv_vidas.setImageResource(R.drawable.unavida);
                        break;
                    case 0:
                        Toast.makeText(this, "Respuesta incorrecta! Te quedaste sin vidas. GAME OVER!!", Toast.LENGTH_LONG).show();
                        tv_manzanas.setText("Manzanas: " + vidas);
                        iv_vidas.setImageResource(R.drawable.fondoet);
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

    /* Método para los numeros aleatorios
     * El score no puede superar 5 */
    public void NumAleatorio() {
        if (score <= 5) {

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
            Toast.makeText(this, "Superaste este Nivel, Felicitaciones!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Main2Activity_Nivel2.class);
            string_score = String.valueOf(score);
            string_vidas = String.valueOf(vidas);
            intent.putExtra("jugador", nombre_jugador);
            intent.putExtra("score", string_score);
            intent.putExtra("vidas", string_vidas);
            startActivity(intent);
            finish();
        }
    }
}