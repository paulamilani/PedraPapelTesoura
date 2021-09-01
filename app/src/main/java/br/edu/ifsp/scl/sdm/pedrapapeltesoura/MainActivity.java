package br.edu.ifsp.scl.sdm.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.Random;

import br.edu.ifsp.scl.sdm.pedrapapeltesoura.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(activityMainBinding.getRoot());

        activityMainBinding.opcaoRg.setOnClickListener(this);
        activityMainBinding.zeroBt.setOnClickListener(this);
        activityMainBinding.umBt.setOnClickListener(this);
        activityMainBinding.doisBt.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int jogadaHumano = -1;

        switch (view.getId()) {
            case R.id.zeroBt:
                jogadaHumano = 0;
                break;
            case R.id.umBt:
                jogadaHumano = 1;
                break;
            case R.id.doisBt:
                jogadaHumano = 2;
                break;
        }

        jogar(jogadaHumano);
    }

    // 0 -> pedra
    // 1 -> papel
    // 2 -> tesoura

    private void jogar(int jogadaHumano) {
        Random random = new Random((System.currentTimeMillis()));
        int jogadaComputador1 = random.nextInt(3);
        int jogadaComputador2 = random.nextInt(3);

        StringBuilder resultadoSb = new StringBuilder();
        resultadoSb.append(" Sua jogada: ");
        resultadoSb.append(jogadaHumano);
        resultadoSb.append("\n");
        resultadoSb.append(" Computador: ");
        resultadoSb.append(jogadaComputador1);
        resultadoSb.append("\n");
        resultadoSb.append(" Computador: ");
        resultadoSb.append(jogadaComputador2);
        resultadoSb.append("\n");

        if (activityMainBinding.opcaoRg.getCheckedRadioButtonId() == R.id.doisRb) {

            //dois jogadores
            if (jogadaHumano == jogadaComputador1) {
                resultadoSb.append("Empate");
            } else {
                if ((jogadaHumano == 0 && jogadaComputador1 == 2) || (jogadaHumano == 1 && jogadaComputador1 == 0) || (jogadaHumano == 2 && jogadaComputador1 == 1)) {
                    resultadoSb.append("Você Venceu!");
                } else {
                    resultadoSb.append("Computador Venceu!");
                }
            }

        //tres jogadores
        } else {
            resultadoSb.append("  deus ajude");

        }

        activityMainBinding.resultadoTv.setText(resultadoSb.toString());


    }
}
