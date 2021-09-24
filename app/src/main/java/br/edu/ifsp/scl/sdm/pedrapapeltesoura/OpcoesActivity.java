package br.edu.ifsp.scl.sdm.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import br.edu.ifsp.scl.sdm.pedrapapeltesoura.databinding.ActivityOpcoesBinding;

public class OpcoesActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityOpcoesBinding activityOpcoesBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOpcoesBinding = ActivityOpcoesBinding.inflate(getLayoutInflater());
        setContentView(activityOpcoesBinding.getRoot());

        activityOpcoesBinding.opcaoRg.setOnClickListener(this);


        activityOpcoesBinding.mainTb.appTb.setTitle("JoKenPo");
        activityOpcoesBinding.mainTb.appTb.setSubtitle("JoKenPo");
        setSupportActionBar(activityOpcoesBinding.mainTb.appTb);
    }

    @Override
    public void onClick(View view) {

        //capturando as configs
        int qtd_jogador = 0;
        if (activityOpcoesBinding.opcaoRg.getCheckedRadioButtonId() == R.id.doisRb) {
            qtd_jogador = 2;

        } else {
            qtd_jogador = 3;
        }

        int qtd_jogada = 0;
        if (activityOpcoesBinding.rodadaRg.getCheckedRadioButtonId() == R.id.umR) {
            qtd_jogada = 1;

        } else if (activityOpcoesBinding.rodadaRg.getCheckedRadioButtonId() == R.id.tresR){
            qtd_jogada = 3;
        }else {
            qtd_jogada = 5;
        }

    }
}