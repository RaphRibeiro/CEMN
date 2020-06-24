package raphaelribeiro.com.runmath;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class DadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dado);
        findViewById(R.id.dado).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prox();
            }
        });

    }

//    Random r = new Random();
//    int pn = r.nextInt(6)+1;
//    int sn = r.nextInt(6)+1;
//
//    int num1 = pn;
//    int num2 = sn;



//    public void exibirNumeros(){
//        AlertDialog.Builder msg = new AlertDialog.Builder(this);
//        msg.setTitle("SEUS NÚMEROS SORTEADOS SÃO:");
//        msg.setMessage(num1+ " E " + num2);
//        msg.setPositiveButton("PRONTO!", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(DadoActivity.this, "Que os jogos comecem!", Toast.LENGTH_SHORT).show();
//                prox();
//            }
//
//
//        });
//        msg.show();
//    }

    public  void prox() {
        Intent nvlUm = new Intent(DadoActivity.this, NivelUmActivity.class);
        startActivity(nvlUm);
        finish();
    }

}
