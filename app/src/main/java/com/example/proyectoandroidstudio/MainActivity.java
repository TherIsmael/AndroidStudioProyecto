package com.example.proyectoandroidstudio;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private TextView tv1;

    private DecimalFormat formato = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.txt_num);
        et2 = findViewById(R.id.txt_num2);
        tv1 = findViewById(R.id.txt_resultado);
    }

    private void ocultarTeclado(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private boolean validar() {
        String valor1 = et1.getText().toString().trim();
        String valor2 = et2.getText().toString().trim();

        if (valor1.isEmpty() || valor2.isEmpty()) {
            Toast.makeText(this, "Por favor ingresa ambos números", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void Limpiar(View view) {
        et1.setText("");
        et2.setText("");
        tv1.setText("0");
        et1.requestFocus();
        ocultarTeclado(view);
    }

    public void Sumar(View view) {
        ocultarTeclado(view);
        if (validar()) {
            double num1 = Double.parseDouble(et1.getText().toString());
            double num2 = Double.parseDouble(et2.getText().toString());
            double suma = num1 + num2;
            tv1.setText(formato.format(suma));
        }
    }

    public void Restar(View view) {
        ocultarTeclado(view);
        if (validar()) {
            double num1 = Double.parseDouble(et1.getText().toString());
            double num2 = Double.parseDouble(et2.getText().toString());
            double resta = num1 - num2;
            tv1.setText(formato.format(resta));
        }
    }

    public void Multiplicar(View view) {
        ocultarTeclado(view);
        if (validar()) {
            double num1 = Double.parseDouble(et1.getText().toString());
            double num2 = Double.parseDouble(et2.getText().toString());
            double mult = num1 * num2;
            tv1.setText(formato.format(mult));
        }
    }

    public void Dividir(View view) {
        ocultarTeclado(view);
        if (validar()) {
            double num1 = Double.parseDouble(et1.getText().toString());
            double num2 = Double.parseDouble(et2.getText().toString());

            if (num2 == 0) {
                Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_SHORT).show();
                tv1.setText("Error");
            } else {
                double div = num1 / num2;
                tv1.setText(formato.format(div));
            }
        }
    }
}