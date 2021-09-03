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
        int jogadaComputador1 = random.nextInt(3);
        int jogadaComputador2 = random.nextInt(3);

        String jgC1 = " ";
        String jgC2 = " ";
        String hu = " ";

        // ------ set imagens ----//
        //computador 1
        int imageJogadaComputadorId1 = -1;
        switch (jogadaComputador1) {
            case 0:
                imageJogadaComputadorId1 = R.mipmap.pedra;
                break;
            case 1:
                imageJogadaComputadorId1 = R.mipmap.papel;
                break;
            case 2:
                imageJogadaComputadorId1 = R.mipmap.tesoura;
                break;
        }
        activityMainBinding.jogadaComputador1.setImageResource(imageJogadaComputadorId1);

        //coputador 2
        int imageJogadaComputadorId2 = -1;
        switch (jogadaComputador2) {
            case 0:
                imageJogadaComputadorId2 = R.mipmap.pedra;
                break;
            case 1:
                imageJogadaComputadorId2 = R.mipmap.papel;
                break;
            case 2:
                imageJogadaComputadorId2 = R.mipmap.tesoura;
                break;
        }
        activityMainBinding.jogadaComputador2.setImageResource(imageJogadaComputadorId2);

        //-------------converte numero da jogada para exibir no resultados--------//
        //humano
        switch (jogadaHumano) {
            case 0:
                hu = "Pedra";
                break;
            case 1:
                hu = "Papel";
                break;
            case 2:
                hu = "Tesoura";
                break;
        }

        //computador 1
        switch (jogadaComputador1) {
            case 0:
                jgC1 = "Pedra";
                break;
            case 1:
                jgC1 = "Papel";
                break;
            case 2:
                jgC1 = "Tesoura";
                break;
        }

        //computador 2
        switch (jogadaComputador2) {
            case 0:
                jgC2 = "Pedra";
                break;
            case 1:
                jgC2 = "Papel";
                break;
            case 2:
                jgC2 = "Tesoura";
                break;
        }

        // --------- exibe jogadas e resultado ------//
        StringBuilder resultadoSb = new StringBuilder();

        // -------- verifica radio button qtd jogadores e executa validações -------//
        if (activityMainBinding.opcaoRg.getCheckedRadioButtonId() == R.id.doisRb) {
            activityMainBinding.jogadaComputador2.setVisibility(View.INVISIBLE);
            activityMainBinding.resultadoC2.setVisibility(View.INVISIBLE);
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
            activityMainBinding.resultadoC2.setVisibility(View.VISIBLE);
            if (jogadaHumano == jogadaComputador1 && jogadaHumano == jogadaComputador2) {
                resultadoSb.append("Empate");

            } else if (jogadaHumano == jogadaComputador2) {
                if ((jogadaHumano == 0 && jogadaComputador1 == 2) || (jogadaHumano == 1 && jogadaComputador1 == 0) || (jogadaHumano == 2 && jogadaComputador1 == 1)) {
                    resultadoSb.append("Você Venceu e tem 1 empate com ComputadorDOIS");
                }
            } else if (jogadaHumano == jogadaComputador1) {
                if ((jogadaHumano == 0 && jogadaComputador2 == 2) || (jogadaHumano == 1 && jogadaComputador2 == 0) || (jogadaHumano == 2 && jogadaComputador2 == 1)) {
                    resultadoSb.append("Você Venceu e tem 1 empate com ComputadorUM");
                }
            } else if (jogadaComputador1 == jogadaComputador2) {
                if ((jogadaHumano == 0 && jogadaComputador2 == 2) || (jogadaHumano == 1 && jogadaComputador2 == 0) || (jogadaHumano == 2 && jogadaComputador2 == 1)) {
                    resultadoSb.append("Você Venceu");
                }
            } else {
                resultadoSb.append("Você perdeu");
            }
        }

        String resultadoH = " Sua jogada: " +  hu + "\n";
        activityMainBinding.resultadoH.setText(resultadoH);
        String resultadoC1 = " ComputadorUM: " + jgC1 + "\n";
        activityMainBinding.resultadoC1.setText(resultadoC1);
        String resultadoC2 = " ComputadorDOIS: " + jgC2 + "\n";
        activityMainBinding.resultadoC2.setText(resultadoC2);
        activityMainBinding.resultadoTv.setText(resultadoSb.toString());
    }

}

