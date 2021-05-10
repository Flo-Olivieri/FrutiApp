package com.florenciaolivieri.frutiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText  et_nombre;
    private ImageView iv_personaje;
    private TextView  tv_bestScore;

    int num_aleatorio = (int) (Math.random() * 10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre    = (EditText)  findViewById(R.id.txt_nombre);
        iv_personaje = (ImageView) findViewById(R.id.imageView_personaje);
        tv_bestScore = (TextView)  findViewById(R.id.textView_BestScore);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }
}