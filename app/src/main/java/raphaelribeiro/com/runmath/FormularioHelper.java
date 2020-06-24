package raphaelribeiro.com.runmath;

import android.widget.EditText;

import raphaelribeiro.com.runmath.dao.RecordeDAO;
import raphaelribeiro.com.runmath.modelo.Recordes;

public class FormularioHelper {

    public void FormularioHelper(){

//        pegarRecordes();
//        RecordeDAO dao = new RecordeDAO(this);

    }

    public Recordes pegarRecordes(){
        Recordes recordes = new Recordes();

        JogadorActivity jogador = new JogadorActivity();
        String nome = jogador.getNome();
        recordes.setNome(nome);

        NivelDoisActivity valorPlacar = new NivelDoisActivity();
        int placar = valorPlacar.getPlacar();
        recordes.setPontos(placar);

        return recordes;

    }
//    private final int pontos;
//    private final EditText nome;
//    JogadorActivity jogador = new JogadorActivity();
//    NivelDoisActivity placar = new NivelDoisActivity();
//
//    public FormularioHelper(){
//
//        nome = (EditText) jogador.findViewById(R.id.nome_jogador);
//        pontos = placar.placar;
//    }
//
//    public Recordes pegaRecordes(){
//        Recordes recordes = new Recordes();
//        recordes.setNome(nome.getText().toString());
//        recordes.setPontos(pontos);
//
//        return recordes;
//    }
}
