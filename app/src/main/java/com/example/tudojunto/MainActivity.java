package com.example.tudojunto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


    }

    public void conversorMoeda(View view){
        Intent page = new Intent(MainActivity.this,conversor_moeda.class);
        startActivity(page);
    }

    public void alcool(View view){
        Intent page = new Intent(MainActivity.this,Alcool.class);
        startActivity(page);
    }

    public void boletin(View view){
        Intent page = new Intent(MainActivity.this,Boletin.class);
        startActivity(page);
    }

    public void conversorTemperatura(View view){
        Intent page = new Intent(MainActivity.this,conversor_temperatura.class);
        startActivity(page);
    }

    public void imc(View view){
        Intent page = new Intent(MainActivity.this,imc.class);
        startActivity(page);
    }
}