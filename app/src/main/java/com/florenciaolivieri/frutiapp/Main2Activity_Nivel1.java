package com.florenciaolivieri.frutiapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class Main2Activity_Nivel1 extends AppCompatActivity {

    private TextView tv_nombre, tv_score;
    private ImageView iv_vidas, iv_aUno, iv_aDos;
    private EditText et_respuesta;

    int score, numAleatorio_uno, numAleatorio_dos, resultado, vidas = 3;
    String nombre_jugador, string_score, string_vidas;

    //vector para las imagenes dinamicas
    String numero [] = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis","siete", "ocho", "nueve"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2__nivel1);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        Toast.makeText(this,R.string.msjToastNivel1, Toast.LENGTH_LONG).show();

        tv_nombre    = (TextView) findViewById(R.id.textview_nombre);
        tv_score     = (TextView) findViewById(R.id.textview_score);
        iv_vidas     = (ImageView) findViewById(R.id.imageview_vidas);
        iv_aUno      = (ImageView) findViewById(R.id.imgview_aUno);
        iv_aDos      = (ImageView) findViewById(R.id.imgview_aDos);
        et_respuesta = (EditText) findViewById(R.id.editText_resultado);

        nombre_jugador = getIntent().getStringExtra("jugador");
        tv_nombre.setText("Jugador: "+ nombre_jugador);

        NumAleatorio();


    }

    /* Metodo para los numeros aleatorios
    * El score no puede superar 10 */
    public void NumAleatorio(){
        if (score <= 9){

            numAleatorio_uno = (int) (Math.random() * 10);
            numAleatorio_dos = (int) (Math.random() * 10);

            resultado = numAleatorio_uno + numAleatorio_dos;

            if (resultado <= 10) {
                for (int i = 0; i < numero.length; i++) {
                    int id = getResources().getIdentifier(numero[i],"drawable",getPackageName());
                    if (numAleatorio_uno == i){
                        iv_aUno.setImageResource(id);
                    } if (numAleatorio_dos == i){
                        iv_aDos.setImageResource(id);
                    }

                }


            } else {
                NumAleatorio();

            }

        } else {
            Intent intent = new Intent(this, Main2Activity_Nivel2.class);
            string_score = String.valueOf(score);
            string_vidas = String.valueOf(vidas);
            intent.putExtra("jugador", nombre_jugador);
            intent.putExtra("score", string_score);
            intent.putExtra("vidas", string_vidas);

            startActivity(intent);
        }
    }
}