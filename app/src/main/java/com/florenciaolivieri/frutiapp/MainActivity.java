package com.florenciaolivieri.frutiapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private EditText  et_nombre;
    private ImageView iv_personaje;
    private TextView  tv_bestScore;

    int num_aleatorio = (int) (Math.random() * 10); // casteo math.random porque es un double


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre    = (EditText)  findViewById(R.id.txt_nombre);
        iv_personaje = (ImageView) findViewById(R.id.imageView_personaje);
        tv_bestScore = (TextView)  findViewById(R.id.textView_BestScore);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        int id; //guardamos la ruta de imagen a mostrar
        if (num_aleatorio == 0 || num_aleatorio == 10) {
            id = getResources().getIdentifier("manzana", "drawable", getPackageName());
            iv_personaje.setImageResource(id);
        } else if(num_aleatorio == 1 || num_aleatorio == 9) {
            id = getResources().getIdentifier("mango", "drawable", getPackageName());
            iv_personaje.setImageResource(id);
        } else if (num_aleatorio == 2 || num_aleatorio == 8) {
            id = getResources().getIdentifier("uva", "drawable", getPackageName());
            iv_personaje.setImageResource(id);
        } else if (num_aleatorio == 3 || num_aleatorio == 7) {
            id = getResources().getIdentifier("naranja", "drawable", getPackageName());
            iv_personaje.setImageResource(id);
        } else if (num_aleatorio == 4 || num_aleatorio == 6 || num_aleatorio == 5) {
            id = getResources().getIdentifier("fresa", "drawable", getPackageName());
            iv_personaje.setImageResource(id);
        }
    }

    public void Jugar(View view){
        String nombre = et_nombre.getText().toString();
        if (!nombre.equals("")) {
            Intent intent = new Intent(this, Main2Activity_Nivel1.class);
            intent.putExtra("jugador", nombre);
            startActivity(intent);
            //finish();
        } else {
            Toast.makeText(this,"Primero debes escribir tu nombre",Toast.LENGTH_SHORT).show();
            et_nombre.requestFocus();
            InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
            imm.showSoftInput(et_nombre, InputMethodManager.SHOW_IMPLICIT);
        }
    }
}