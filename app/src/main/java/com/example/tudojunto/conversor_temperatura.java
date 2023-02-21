package com.example.tudojunto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class conversor_temperatura extends AppCompatActivity {
    TextView entrada;
    TextView saida;
    RadioGroup grupo;
    String convertido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor_temperatura);
        entrada = findViewById(R.id.txt_entrada);
        saida = findViewById(R.id.saida4);
        grupo = findViewById(R.id.groupEscolhas);


    }

    public void converter(View view){
        DecimalFormat arredondar = new DecimalFormat("#.#");

        if(TextUtils.isEmpty(entrada.getText().toString())){
            Toast.makeText(conversor_temperatura.this,"Favor insira um valor para ser convertido",Toast.LENGTH_SHORT).show();
        }else {

            int vlrSelecionado =grupo.getCheckedRadioButtonId();

            switch (vlrSelecionado){
                case R.id.br_Fah:
                    double fah = Double.parseDouble(entrada.getText().toString());
                    convertido =arredondar.format((fah * 1.8)+32);
                    saida.setText(convertido);
                    break;
                case R.id.br_kelvin:
                    double kelvin = Double.parseDouble(entrada.getText().toString());
                    convertido =arredondar.format(kelvin +273.15);
                    saida.setText(convertido);
                    break;

                default:
                    Toast.makeText(conversor_temperatura.this,"Favor escolha uma opção para ser convertido",Toast.LENGTH_SHORT).show();
                    break;

            }

        }

    }



}