package raphaelribeiro.com.runmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ComoJogarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_como_jogar);

        Button nxtpg = (Button) findViewById(R.id.como_jogar);
        nxtpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jogar = new Intent(ComoJogarActivity.this, JogadorActivity.class);
                startActivity(jogar);
                finish();
            }
        });
        findViewById(R.id.como_jogar);
    }


}
