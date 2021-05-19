package com.florenciaolivieri.frutiapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity_Nivel1 extends AppCompatActivity {

    private TextView tv_nombre, tv_score;
    private ImageView iv_vidas, iv_aUno, iv_aDos;
    private EditText et_respuesta;

    int score, numAleatorio_uno, numAleatorio_dos, resultado, vidas = 3;
    String nombre_jugador, string_score, string_vidas;

    String numero [] = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis","siete", "ocho", "nueve"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2__nivel1);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowHomeEnabled(true);

        Toast.makeText(this,R.string.jugador_nombre, Toast.LENGTH_LONG).show();
        Toast.makeText(this,R.string.msjToastNivel1, Toast.LENGTH_LONG).show();

        tv_nombre    = (TextView) findViewById(R.id.textview_nombre);
        tv_score     = (TextView) findViewById(R.id.textview_score);
        iv_vidas     = (ImageView) findViewById(R.id.imageview_vidas);
        iv_aUno      = (ImageView) findViewById(R.id.imgview_aUno);
        iv_aDos      = (ImageView) findViewById(R.id.imgview_aDos);
        et_respuesta = (EditText) findViewById(R.id.editText_resultado);

        nombre_jugador = getIntent().getStringExtra("jugador");
        tv_nombre.setText("Jugador: "+ nombre_jugador);


    }
}