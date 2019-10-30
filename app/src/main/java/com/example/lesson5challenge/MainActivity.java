package com.example.lesson5challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean respuesta;
    private Toast toast;
    private Button verdad;
    private Button falso;
    private TextView pregunta;
    private int iterar = 0;
    private String[] preguntas = {"2 + 2 = 4", "¿Está la luna hecha de queso?","¿Son los memes beneficiosos para el medio ambiente?"};
    private boolean[] respuestas = {true,false,true};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void verdadero(View view) {
        verdad = findViewById(R.id.verdadero);
        respuesta = true;
        procesar(respuesta);
    }
    public void falso(View view){
        falso = findViewById(R.id.falso);
        respuesta = false;
        procesar(respuesta);
    }

    public void previous(View view){
        if (iterar<=0){
            iterar = 0;
        }else{
            iterar--;
        }
        showQuestion();
    }

    public void next(View view){
        if (iterar>=preguntas.length-1){
            iterar = preguntas.length-1;
        }else{
            iterar++;
        }
        showQuestion();
    }

    public void procesar(boolean respuesta){
        if (respuestas[iterar] == respuesta){
            toast = Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT);
            toast.show();
        }else{
            toast = Toast.makeText(getApplicationContext(), "Incorrect :(", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void showQuestion(){
        pregunta = findViewById(R.id.preguntar);
        pregunta.setText(preguntas[iterar]);
    }


}
