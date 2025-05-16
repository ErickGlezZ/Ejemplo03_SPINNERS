package com.example.ejemplo03_spinners;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {



    private Spinner spinnerGrados1, spinnerGrados2;
    private EditText cajaTemp, cajaResultado;
    private ConvertirTemperatura conversion = new ConvertirTemperatura();

    ArrayList<String> listaGrados;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spinnerGrados1 = findViewById(R.id.spinner_grados_1);
        spinnerGrados2 = findViewById(R.id.spinner_graodos_2);

        cajaTemp = findViewById(R.id.caja_grados);
        cajaResultado = findViewById(R.id.caja_resultados);

        String nombresGrados[] = {"Celsius", "Fahrenheit", "kelvin", "Rankin"};

        listaGrados = new ArrayList<>();
        listaGrados.add("Elige una opc...");
        listaGrados.add("Celsius");
        listaGrados.add("Fahrenheit");
        listaGrados.add("Kelvin");
        listaGrados.add("Rankin");


        ArrayAdapter<String> adaptadorGrador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaGrados);

        spinnerGrados1.setAdapter(adaptadorGrador);
        spinnerGrados2.setAdapter(adaptadorGrador);

        spinnerGrados1.setOnItemSelectedListener(this);
        spinnerGrados2.setOnItemSelectedListener(this);

        cajaResultado.setEnabled(false);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

       // Toast.makeText(this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();



        if (parent.getId() == R.id.spinner_grados_1){
            //Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();

            if (parent.getSelectedItem().toString().equals("Celsius")){
                cajaResultado.setText("");
                ArrayList<String> listaTemporal = (ArrayList<String>) listaGrados.clone();

                listaTemporal.remove("Celsius");
                //listaGrados.remove("Celsius");
                ArrayAdapter<String> nuevoAdaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaTemporal);
                spinnerGrados2.setAdapter(nuevoAdaptador);
            } else if (parent.getSelectedItem().toString().equals("Fahrenheit")) {
                cajaResultado.setText("");
                ArrayList<String> listaTemporal = (ArrayList<String>) listaGrados.clone();

                listaTemporal.remove("Fahrenheit");

                ArrayAdapter<String> nuevoAdaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaTemporal);
                spinnerGrados2.setAdapter(nuevoAdaptador);
            } else if (parent.getSelectedItem().toString().equals("Kelvin")){
                cajaResultado.setText("");
                ArrayList<String> listaTemporal = (ArrayList<String>) listaGrados.clone();

                listaTemporal.remove("Kelvin");

                ArrayAdapter<String> nuevoAdaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaTemporal);
                spinnerGrados2.setAdapter(nuevoAdaptador);

            } else if (parent.getSelectedItem().toString().equals("Rankin")){
                cajaResultado.setText("");
                ArrayList<String> listaTemporal = (ArrayList<String>) listaGrados.clone();

                listaTemporal.remove("Rankin");

                ArrayAdapter<String> nuevoAdaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaTemporal);
                spinnerGrados2.setAdapter(nuevoAdaptador);
            }
        } else if (parent.getId() == R.id.spinner_graodos_2) {

            //Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
            if (cajaTemp.getText().toString().isEmpty()){
                spinnerGrados1.setSelection(0);
                spinnerGrados2.setSelection(0);
                Toast.makeText(this, "Ingresa una temperatura primero", Toast.LENGTH_SHORT).show();
                return;
            }


            double valor = Double.parseDouble(String.valueOf(cajaTemp.getText()));
            double resultado = 0;


            if (spinnerGrados1.getSelectedItem().toString().equals("Celsius") && spinnerGrados2.getSelectedItem().toString().equals("Fahrenheit") ) {

                resultado = conversion.centigradosAFahrenheit(valor);
                cajaResultado.setText(String.valueOf(resultado));

            } else if (spinnerGrados1.getSelectedItem().toString().equals("Celsius") && spinnerGrados2.getSelectedItem().toString().equals("Kelvin") ) {

                resultado = conversion.centigradosAKelvin(valor);
                cajaResultado.setText(String.valueOf(resultado));

            } else if (spinnerGrados1.getSelectedItem().toString().equals("Celsius") && spinnerGrados2.getSelectedItem().toString().equals("Rankin") ) {

                resultado = conversion.centigradosARankine(valor);
                cajaResultado.setText(String.valueOf(resultado));

            } else if (spinnerGrados1.getSelectedItem().toString().equals("Fahrenheit") && spinnerGrados2.getSelectedItem().toString().equals("Celsius") ) {

                resultado = conversion.fahrenheitACentigrados(valor);
                cajaResultado.setText(String.valueOf(resultado));

            } else if (spinnerGrados1.getSelectedItem().toString().equals("Fahrenheit") && spinnerGrados2.getSelectedItem().toString().equals("Kelvin") ) {

                resultado = conversion.fahrenheitAKelvin(valor);
                cajaResultado.setText(String.valueOf(resultado));

            } else if (spinnerGrados1.getSelectedItem().toString().equals("Fahrenheit") && spinnerGrados2.getSelectedItem().toString().equals("Rankin") ) {

                resultado = conversion.fahrenheitARankine(valor);
                cajaResultado.setText(String.valueOf(resultado));

            } else if (spinnerGrados1.getSelectedItem().toString().equals("Kelvin") && spinnerGrados2.getSelectedItem().toString().equals("Celsius") ) {

                resultado = conversion.kelvinACentigrados(valor);
                cajaResultado.setText(String.valueOf(resultado));

            } else if (spinnerGrados1.getSelectedItem().toString().equals("Kelvin") && spinnerGrados2.getSelectedItem().toString().equals("Fahrenheit") ) {

                resultado = conversion.kelvinAFahrenheit(valor);
                cajaResultado.setText(String.valueOf(resultado));

            } else if (spinnerGrados1.getSelectedItem().toString().equals("Kelvin") && spinnerGrados2.getSelectedItem().toString().equals("Rankin") ) {

                resultado = conversion.kelvinARankine(valor);
                cajaResultado.setText(String.valueOf(resultado));

            } else if (spinnerGrados1.getSelectedItem().toString().equals("Rankin") && spinnerGrados2.getSelectedItem().toString().equals("Celsius") ) {

                resultado = conversion.rankineACentigrados(valor);
                cajaResultado.setText(String.valueOf(resultado));

            } else if (spinnerGrados1.getSelectedItem().toString().equals("Rankin") && spinnerGrados2.getSelectedItem().toString().equals("Fahrenheit") ) {

                resultado = conversion.rankineAFahrenheit(valor);
                cajaResultado.setText(String.valueOf(resultado));

            } else if (spinnerGrados1.getSelectedItem().toString().equals("Rankin") && spinnerGrados2.getSelectedItem().toString().equals("Kelvin") ) {

                resultado = conversion.rankineAKelvin(valor);
                cajaResultado.setText(String.valueOf(resultado));

            }

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}

class ConvertirTemperatura{

    public double centigradosAFahrenheit(double centigrados) {

        return (centigrados * 1.8) + 32;
    }

    public double centigradosAKelvin(double centigrados) {

        return centigrados + 273.15;
    }

    public double centigradosARankine(double centigrados) {

        return centigrados * 1.8 + 491.67;
    }

    public double fahrenheitACentigrados(double fahrenheit) {

        return (fahrenheit - 32) * 5/9;
    }

    public double fahrenheitAKelvin(double fahrenheit) {

        return (fahrenheit - 32) * 5/9 + 273.15;
    }

    public double fahrenheitARankine(double fahrenheit) {

        return fahrenheit + 459.67;
    }

    public double kelvinACentigrados(double kelvin) {

        return kelvin - 273.15;
    }

    public double kelvinAFahrenheit(double kelvin) {

        return (kelvin - 273.15) * 1.8 + 32;
    }

    public double kelvinARankine(double kelvin) {

        return kelvin * 1.8;
    }

    public double rankineACentigrados(double rankine) {

        return (rankine - 491.67) * 5/9;
    }

    public double rankineAFahrenheit(double rankine) {

        return rankine - 459.67;
    }

    public double rankineAKelvin(double rankine) {

        return rankine * 5/9;
    }

}