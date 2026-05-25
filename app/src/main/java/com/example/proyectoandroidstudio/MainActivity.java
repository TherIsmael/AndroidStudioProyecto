package com.example.proyectoandroidstudio;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.txt_num);
        et2 = findViewById(R.id.txt_num2);
        tv1 = findViewById(R.id.txt_resultado);
    }

    // Un método auxiliar para verificar si los campos están vacíos y ahorrar código
    private boolean validarCampos() {
        String valor1 = et1.getText().toString().trim();
        String valor2 = et2.getText().toString().trim();

        if (valor1.isEmpty() || valor2.isEmpty()) {
            Toast.makeText(this, "Por favor ingresa ambos números", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    // --- MÉTODOS DE OPERACIÓN ---

    public void Sumar(View view) {
        if (validarCampos()) {
            double num1 = Double.parseDouble(et1.getText().toString());
            double num2 = Double.parseDouble(et2.getText().toString());
            double suma = num1 + num2;
            tv1.setText(String.valueOf(suma));
        }
    }

    public void Restar(View view) {
        if (validarCampos()) {
            double num1 = Double.parseDouble(et1.getText().toString());
            double num2 = Double.parseDouble(et2.getText().toString());
            double resta = num1 - num2;
            tv1.setText(String.valueOf(resta));
        }
    }

    public void Multiplicar(View view) {
        if (validarCampos()) {
            double num1 = Double.parseDouble(et1.getText().toString());
            double num2 = Double.parseDouble(et2.getText().toString());
            double multiplicacion = num1 * num2;
            tv1.setText(String.valueOf(multiplicacion));
        }
    }

    public void Dividir(View view) {
        if (validarCampos()) {
            double num1 = Double.parseDouble(et1.getText().toString());
            double num2 = Double.parseDouble(et2.getText().toString());

            // Validación crucial: No se puede dividir entre cero
            if (num2 == 0) {
                Toast.makeText(this, "El universo explotará si divides entre cero", Toast.LENGTH_LONG).show();
                tv1.setText("Error");
            } else {
                double division = num1 / num2;
                tv1.setText(String.valueOf(division));
            }
        }
    }
}