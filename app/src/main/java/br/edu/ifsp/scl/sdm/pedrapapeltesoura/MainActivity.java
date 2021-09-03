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

    // 0 -> Pedra
    // 1 -> Papel
    // 2 -> Tesoura

    private void jogar(int jogadaHumano) {

        Random random = new Random((System.currentTimeMillis()));
        int jogadaComputador2 = random.nextInt(3);
        int jogadaComputador1 = random.nextInt(3);

        //computador 1
        int imageJogadaComputadorId1 = -1;
        switch (jogadaComputador1) {
            case 0:
                imageJogadaComputadorId1 = R.mipmap.zero;
                break;
            case 1:
                imageJogadaComputadorId1 = R.mipmap.two;
                break;
            case 2:
                imageJogadaComputadorId1 = R.mipmap.five;
                break;
        }
        activityMainBinding.jogadaComputador1.setImageResource(imageJogadaComputadorId1);

        //coputador 2
        int imageJogadaComputadorId2 = -1;
        switch (jogadaComputador1) {
            case 0:
                imageJogadaComputadorId2 = R.mipmap.zero;
                break;
            case 1:
                imageJogadaComputadorId2 = R.mipmap.two;
                break;
            case 2:
                imageJogadaComputadorId2 = R.mipmap.five;
                break;
        }
        activityMainBinding.jogadaComputador2.setImageResource(imageJogadaComputadorId2);

        StringBuilder resultadoSb = new StringBuilder();
        resultadoSb.append(" Sua jogada: ");
        resultadoSb.append(jogadaHumano);
        resultadoSb.append("\n");

        resultadoSb.append(" ComputadorUM: ");
        resultadoSb.append(jogadaComputador1);
        resultadoSb.append("\n");

        resultadoSb.append(" ComputadorDOIS: ");
        resultadoSb.append(jogadaComputador2);
        resultadoSb.append("\n");

        if (activityMainBinding.opcaoRg.getCheckedRadioButtonId() == R.id.doisRb) {
            activityMainBinding.jogadaComputador2.setVisibility(View.INVISIBLE);
            if (jogadaHumano == jogadaComputador1) {
                resultadoSb.append("Empate");
            } else {
                if ((jogadaHumano == 0 && jogadaComputador1 == 2) || (jogadaHumano == 1 && jogadaComputador1 == 0) || (jogadaHumano == 2 && jogadaComputador1 == 1)) {
                    resultadoSb.append("Você venceu");
                } else {
                    resultadoSb.append("Você perdeu");
                }
            }

        }

        if (activityMainBinding.opcaoRg.getCheckedRadioButtonId() == R.id.tresRb) {
            activityMainBinding.jogadaComputador2.setVisibility(View.VISIBLE);
            if (jogadaHumano == jogadaComputador1 && jogadaHumano == jogadaComputador2) {
                resultadoSb.append("Empate");

            } else if (jogadaComputador2 == jogadaHumano) {
                if ((jogadaHumano == 0 && jogadaComputador1 == 2) || (jogadaHumano == 1 && jogadaComputador1 == 0) || (jogadaHumano == 2 && jogadaComputador1 == 1)) {
                    resultadoSb.append("Você Venceu e tem 1 empate com ComputadorDOIS");
                }
            } else if (jogadaComputador1 == jogadaHumano) {
                if ((jogadaHumano == 0 && jogadaComputador2 == 2) || (jogadaHumano == 1 && jogadaComputador2 == 0) || (jogadaHumano == 2 && jogadaComputador2 == 1)) {
                    resultadoSb.append("Você Venceu e tem 1 empate com ComputadorUM");
                }
            } else {
                resultadoSb.append("Você perdeu");
            }
        }

        activityMainBinding.resultadoTv.setText(resultadoSb.toString());



        //-------------converte numero da jogada para string --------//
    }

}

