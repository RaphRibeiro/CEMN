package raphaelribeiro.com.runmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JogadorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogador);

        final EditText nomeJogador = (EditText) findViewById(R.id.nome_jogador);
//        nomeJogador.getText();
//        nome = nomeJogador.toString();


        Button nxtpg = (Button) findViewById(R.id.ok);
        nxtpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nomeJogador.getText().toString().trim().equals("")){
                    Toast.makeText(JogadorActivity.this, "Ops! Não esqueça seu nome", Toast.LENGTH_SHORT).show();
                }else{
                    nome = nomeJogador.getText().toString();
                    proximaPG();
                }
            }
        });
        findViewById(R.id.jogar);
    }

    private static String nome;


    public  void proximaPG(){
        Intent cartela = new Intent(JogadorActivity.this, Cartelas.class);
        startActivity(cartela);
        finish();
    }


    public static String getNome() {
        String jogador = nome ;
        return jogador;
    }


}
