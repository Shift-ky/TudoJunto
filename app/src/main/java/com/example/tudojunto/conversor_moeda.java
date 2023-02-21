package com.example.tudojunto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class conversor_moeda extends AppCompatActivity {

    EditText entrada;
    TextView saida;
    RadioGroup escolha;
    ImageView imagen;
    double res;
    double real;
    String convertido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor_moeda);

        entrada = findViewById(R.id.entrada);
        saida = findViewById(R.id.saida);
        escolha = findViewById(R.id.RgEscolha);
        imagen = findViewById(R.id.imgSaida);
    }

    public void converter(View view){
        if(TextUtils.isEmpty(entrada.getText().toString())){
            Toast.makeText(conversor_moeda.this,"Informe um valor para ser convertido",Toast.LENGTH_LONG).show();

        }else{
            int vlrEscolhido = escolha.getCheckedRadioButtonId();
            real =Double.parseDouble(entrada.getText().toString());
            DecimalFormat converter = new DecimalFormat("#.##");
            switch (vlrEscolhido){
                case R.id.RbDolar:
                    convertido = converter.format(real / 5.09);
                    saida.setText("US$ "+ convertido);
                    imagen.setImageResource(R.drawable.dolar);
                    break;

                case R.id.RbEuro:
                    convertido = converter.format(real  / 5.51);
                    saida.setText("€ "+ convertido);
                    imagen.setImageResource(R.drawable.euro);
                    break;

                case R.id.RbLibra:
                    convertido = converter.format(real  / 6.27);
                    saida.setText("£"+ convertido);
                    imagen.setImageResource(R.drawable.libra);
                    break;
                case R.id.RbYens:
                    convertido = converter.format(real  / 0.39);
                    saida.setText("£"+ convertido);
                    imagen.setImageResource(R.drawable.iene);
                    break;
                default:
                    Toast.makeText(conversor_moeda.this,"Escolha uma moeda para ser convertido",Toast.LENGTH_LONG).show();
                    break;
            }

        }
    }
}