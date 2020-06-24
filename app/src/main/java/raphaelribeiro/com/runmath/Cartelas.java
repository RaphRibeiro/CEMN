package raphaelribeiro.com.runmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cartelas extends AppCompatActivity {

    //Valor do botão escolhido, para ser resultdo da resposta
    //Chama classe ValorCartela
    ValorCartela valor = new ValorCartela();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartelas);


        Button um = (Button) findViewById(R.id.um);
        um.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor.setCartela(1);
                proximaPG();
            }
        });

        Button dois = (Button) findViewById(R.id.dois);
        dois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor.setCartela(2);
               proximaPG();
            }
        });

        Button tres = (Button) findViewById(R.id.tres);
        tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor.setCartela(3);
                proximaPG();
            }
        });

        Button quatro = (Button) findViewById(R.id.quatro);
        quatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor.setCartela(4);
                proximaPG();
            }
        });

        Button cinco = (Button) findViewById(R.id.cinco);
        cinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor.setCartela(5);
               proximaPG();
            }
        });

        Button seis = (Button) findViewById(R.id.seis);
        seis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor.setCartela(6);
               proximaPG();
            }
        });

        Button sete = (Button) findViewById(R.id.sete);
        sete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor.setCartela(7);
                proximaPG();
            }
        });

        Button oito = (Button) findViewById(R.id.oito);
        oito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor.setCartela(8);
                proximaPG();
            }
        });

        Button nove = (Button) findViewById(R.id.nove);
        nove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor.setCartela(9);
                proximaPG();
            }
        });

        Button dez = (Button) findViewById(R.id.dez);
        dez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor.setCartela(10);
                proximaPG();
            }
        });

        Button onze = (Button) findViewById(R.id.onze);
        onze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor.setCartela(11);
                proximaPG();
            }
        });

        Button doze = (Button) findViewById(R.id.doze);
        doze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor.setCartela(12);
               proximaPG();
            }
        });
    }


    public  void proximaPG(){
        Intent dado = new Intent(Cartelas.this, DadoActivity.class);
        startActivity(dado);
        finish();
    }

}
