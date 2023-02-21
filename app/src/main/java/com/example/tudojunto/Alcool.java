package com.example.tudojunto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Alcool extends AppCompatActivity {

    TextView Egasolina;
    TextView Ealcool;
    TextView saida;
    ImageView imgAlcool;
    ImageView imgGasolina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcool);

        Egasolina = findViewById(R.id.entradaGasolina);
        Ealcool = findViewById(R.id.entradaAlcool);
        saida = findViewById(R.id.saida3);
        imgAlcool = findViewById(R.id.imgAlcool);
        imgGasolina = findViewById(R.id.imgGasolina);
    }

    public void conversor(View view){
        if(TextUtils.isEmpty(Egasolina.getText().toString()) || TextUtils.isEmpty(Ealcool.getText().toString())){
            Toast.makeText(Alcool.this,"Insira os valores para ser verificado",Toast.LENGTH_SHORT);
        }else{
            double gasolina = Double.parseDouble(Egasolina.getText().toString());
            double alcool = Double.parseDouble(Ealcool.getText().toString());
            double resultado = (double) (gasolina *0.7);
            double res = alcool / gasolina;

            if((resultado <= alcool) && (res >= 0.7)){
                imgGasolina.setImageResource(R.drawable.gasolina);
                imgAlcool.setVisibility(View.INVISIBLE);
                imgGasolina.setVisibility(View.VISIBLE);
                saida.setText("GASOLINA é a melhor opção");
            }else{
                imgAlcool.setImageResource(R.drawable.etanol);
                imgGasolina.setVisibility(View.INVISIBLE);
                imgAlcool.setVisibility(View.VISIBLE);
                saida.setText("ALCOOL é a melhor opção");
            }
        }


    }
}