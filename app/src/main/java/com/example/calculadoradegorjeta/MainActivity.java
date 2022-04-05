package com.example.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextView textGorjeta, textTotal, textPorcento;
    private TextInputEditText textInputValor;
    private SeekBar seekBarPorcento;
    private double porcentagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textGorjeta     = findViewById(R.id.textGorjeta);
        textTotal       = findViewById(R.id.textTotal);
        textPorcento    = findViewById(R.id.textPorcento);
        textInputValor  = findViewById(R.id.textInputValor);
        seekBarPorcento = findViewById(R.id.seekBarPorcento);

        seekBarPorcento.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                textPorcento.setText(progress + "%");
                porcentagem = progress * 0.01;

                calcula();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    public void calcula(){

        String leValor = textInputValor.getText().toString();
        Double valor = Double.parseDouble(leValor);

        Double gorjeta = (valor * porcentagem);
        textGorjeta.setText("R$" + gorjeta);
        valor += (valor * porcentagem);
        textTotal.setText("R$" + valor);

    }
}