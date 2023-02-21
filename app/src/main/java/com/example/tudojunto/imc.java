package com.example.tudojunto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class imc extends AppCompatActivity {

    TextView peso;
    TextView altura;
    TextView saida;
    TextView saida2;

    String convertido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);
        peso = findViewById(R.id.entradaPeso);
        altura = findViewById(R.id.entradaAlt);
        saida = findViewById(R.id.saida1);
        saida2 = findViewById(R.id.saida2);
    }

    public void conversorImc(View view){
        DecimalFormat arredondar = new DecimalFormat("#.#");

        if(TextUtils.isEmpty(altura.getText().toString()) || TextUtils.isEmpty(peso.getText().toString())){
            Toast.makeText(imc.this,"Favor insira um valor para ser convertido",Toast.LENGTH_SHORT).show();
        }else {
            double peso1 = Double.parseDouble(peso.getText().toString());
            double altura1 = Double.parseDouble(altura.getText().toString());
            double resultado = peso1 /(altura1*altura1);

            if(resultado <= 16.9){
                convertido = arredondar.format(resultado);
                saida.setText(convertido);
                saida2.setText("Voces está muito abaixo do peso");
            }else if(resultado <= 18.4){
                convertido = arredondar.format(resultado);
                saida.setText(convertido);
                saida2.setText("Voces está abaixo do peso");
            }else if(resultado <= 24.9){
                convertido = arredondar.format(resultado);
                saida.setText(convertido);
                saida2.setText("Voces está no peso normal");
            }else if(resultado <= 29.9) {
                convertido = arredondar.format(resultado);
                saida.setText(convertido);
                saida2.setText("Voces está acima do peso");
            }else if(resultado <= 34.9) {
                convertido = arredondar.format(resultado);
                saida.setText(convertido);
                saida2.setText("Voces está com obesidade de grau I");
            }else if(resultado <= 40) {
                convertido = arredondar.format(resultado);
                saida.setText(convertido);
                saida2.setText("Voces está com obesidade de grfau II");
            }else {
                convertido = arredondar.format(resultado);
                saida.setText(convertido);
                saida2.setText("Voces está com obesidade de grau III");
            }
        }

    }
}