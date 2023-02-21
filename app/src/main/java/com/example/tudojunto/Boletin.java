package com.example.tudojunto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Boletin extends AppCompatActivity {

    EditText n1;
    EditText n2;
    EditText n3;
    EditText nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boletin);

        n1 = findViewById(R.id.nota1);
        n2 = findViewById(R.id.nota22);
        n3 = findViewById(R.id.nota33);
        nome = findViewById(R.id.nomeAluno);
    }

    public void calculaMedia(View view){
        double nota1 = Double.parseDouble(n1.getText().toString());
        double nota2 = Double.parseDouble(n2.getText().toString());
        double nota3 = Double.parseDouble(n3.getText().toString());
        String nome1 = nome.getText().toString();
        String conceito;
        String situacao = "";
        final View layout =getLayoutInflater().inflate(R.layout.layout_aluno,null);

        AlertDialog.Builder alerta = new AlertDialog.Builder(Boletin.this);
        AlertDialog.Builder alertaR = new AlertDialog.Builder(Boletin.this);
        AlertDialog.Builder alertaF = new AlertDialog.Builder(Boletin.this);

        if(TextUtils.isEmpty(n1.getText().toString()) || TextUtils.isEmpty(n2.getText().toString()) || TextUtils.isEmpty(n3.getText().toString())){
            Toast.makeText(Boletin.this,"Digite os valores para saber a média",Toast.LENGTH_LONG).show();

        }else{
            double media = (nota1 + nota2 + (nota3*2))/4;

            if(media <=5){
                conceito = "D";
                situacao = ": REPROVADO!!!";
            }else if(media <=7){
                conceito = "C";
                situacao = " de: RECUPERAÇÃO";
            }else if(media <=8){
                conceito = "B";
                situacao = ": APROVADO!!!";
            }else{
                conceito = "A";
                situacao = ": APROVADO!!!";
            }
            //Alerta Dialog para o aluno que foi aprovado ou reprovado;
            if(conceito.equals("C")){
                alerta.setTitle("SITUAÇÃO DO ALUNO");
                alerta.setMessage("Olá "+nome1+"\nSua média é: "+media+" \nCom o conceito: '"+conceito+"' \nO aluno está"+situacao);
                alerta.setCancelable(false);
                alerta.setPositiveButton("RECUPERAÇÃO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alertaR.setView(layout);
                        alertaR.setTitle("Calculo Salário");
                        alertaR.setMessage("Insira os valores abaixo para calcular");
                        alertaR.setPositiveButton("calcular", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText notaR = layout.findViewById(R.id.notaAlunoLa);
                                double nota = Double.parseDouble(notaR.getText().toString());
                                double Recuperacao = (media + (nota *2)) /3;
                                String nSituacao ="";

                                if(Recuperacao <=7){
                                    nSituacao = "REPROVADO";
                                }else{
                                    nSituacao = "APROVADO";
                                }
                                alertaF.setTitle("SITUAÇÃO DO ALUNO");
                                alertaF.setMessage("Olá "+nome1+"\nSua média é:"+Recuperacao+" \nO aluno está: "+nSituacao);
                                alertaF.create().show();

                            }
                        });
                        alertaR.create().show();

                    }
                });
                alerta.create().show();
            }else{
                alerta.setTitle("SITUAÇÃO DO ALUNO");
                alerta.setMessage("Olá "+nome1+"\nSua média é: "+media+" \nCom o conceito = '"+conceito+"' \nO aluno está: "+situacao);
                alerta.create().show();
            }

        } // Fim do laço de repetição principal
    } // Fim da minha função calcular média do aluno
}