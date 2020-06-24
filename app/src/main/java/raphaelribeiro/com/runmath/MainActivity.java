package raphaelribeiro.com.runmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button nxtpg = (Button) findViewById(R.id.jogar);
        nxtpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jogar = new Intent(MainActivity.this, JogadorActivity.class);
                startActivity(jogar);
            }
        });
        findViewById(R.id.jogar);

        Button cojogar = (Button) findViewById(R.id.como_jogar);
        cojogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent comojogar = new Intent(MainActivity.this, ComoJogarActivity.class);
                startActivity(comojogar);
            }
        });
        findViewById(R.id.como_jogar);

        Button recordes = (Button) findViewById(R.id.recordes);
        recordes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recordes = new Intent(MainActivity.this, RecordesActivity.class);
                startActivity(recordes);
            }
        });
        findViewById(R.id.recordes);
    }

}
