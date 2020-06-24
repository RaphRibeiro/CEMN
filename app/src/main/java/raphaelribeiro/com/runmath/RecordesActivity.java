package raphaelribeiro.com.runmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import raphaelribeiro.com.runmath.adapter.RecordesAdapter;
import raphaelribeiro.com.runmath.dao.RecordeDAO;
import raphaelribeiro.com.runmath.modelo.Recordes;

public class RecordesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordes);

        Button nxtpg = (Button) findViewById(R.id.recorde_jogar_denovo);
        nxtpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jogar = new Intent(RecordesActivity.this, MainActivity.class);
                startActivity(jogar);
                finish();
            }
        });
        findViewById(R.id.recorde_jogar_denovo);


        RecordeDAO dao = new RecordeDAO(this);
        List<Recordes> recordes = dao.listarecordes();
        dao.close();


        ListView listaRecordes = (ListView) findViewById(R.id.lista_de_recordes);

        RecordesAdapter adapter = new RecordesAdapter(this, recordes);
//        ArrayAdapter<Recordes> adapter = new ArrayAdapter<Recordes>(this, android.R.layout.simple_list_item_1,recordes);
        listaRecordes.setAdapter(adapter);
    }
}
