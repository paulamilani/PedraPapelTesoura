package br.edu.ifsp.scl.sdm.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup opcaoRg;
    private Button pedraBt, papelBt, tesouraBt;
    private TextView resultadoTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opcaoRg = findViewById(R.id.opcaoRg);
        pedraBt = findViewById(R.id.pedraBt);
        papelBt = findViewById(R.id.papelBt);
        tesouraBt = findViewById(R.id.tesouraBt);

        opcaoRg.setOnClickListener(this);
        pedraBt.setOnClickListener(this);
        papelBt.setOnClickListener(this);
        tesouraBt.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

    }
}