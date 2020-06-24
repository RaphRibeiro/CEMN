package raphaelribeiro.com.runmath;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.xml.sax.Parser;

import java.text.DecimalFormat;
import java.util.Random;

public class NivelUmActivity extends AppCompatActivity {
    private static int respostaExpressao;
    private static int contavazio=0;
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        exibirNumeros();
        limpaPlacar();
        //Números sorteados e resultado escolhido
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel_um);

        Button primeiroNumero = (Button) findViewById(R.id.primeiro_numero);
        primeiroNumero.setText(""+pn);

        Button segundoNumero = (Button) findViewById(R.id.segundo_numero);
        segundoNumero.setText(""+sn);

        Button resultado = (Button) findViewById(R.id.resultado);
        resultado.setText("= "+resposta);

        final TextView somatorio = (TextView) findViewById(R.id.somatorio);
        somatorio.setText(conta);

        //Botão Limpar
        final Button limpar = (Button) findViewById(R.id.limpar);
        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpar();
                bonus =0;
            }
        });

        //Ao apertar para descobrir a resposta
        resultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confereResposta();

            }
        });

        //Valor Placar
        TextView score = (TextView) findViewById(R.id.score);
        score.setText(""+placar);




        //Operações Matemáticas

        Button soma = (Button) findViewById(R.id.mais);
        soma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topoVet++;
                contaVet[topoVet]="+";
                conta = conta + "+ ";
                bonus = bonus + 25;
                voltar();
            }
        });


        Button subtracao = (Button) findViewById(R.id.menos);
        subtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topoVet++;
                contaVet[topoVet]="-";
                conta = conta + "- ";
                bonus = bonus + 25;
                voltar();
            }
        });

        Button multiplicacao = (Button) findViewById(R.id.multiplicacao);
        multiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topoVet++;
                contaVet[topoVet]="x";
                conta = conta + "x ";
                bonus = bonus + 100;
                voltar();
            }
        });

        Button dividir = (Button) findViewById(R.id.divisao);
        dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topoVet++;
                contaVet[topoVet]="/";
                conta = conta + "/ ";
                bonus = bonus + 100;
                voltar();
            }
        });

        Button abrePar = (Button) findViewById(R.id.parentese_abre);
        abrePar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topoVet++;
                contaVet[topoVet]="(";
                conta = conta + "( ";
                bonus = bonus + 150;
                voltar();
            }
        });

        Button fechaPar = (Button) findViewById(R.id.parentese_fecha);
        fechaPar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topoVet++;
                contaVet[topoVet]=")";
                conta = conta + ") ";
                bonus = bonus + 150;
                voltar();
            }
        });

        final Button num1 = (Button) findViewById(R.id.primeiro_numero);
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topoVet++;
                contaVet[topoVet]=Integer.toString(pn);
                conta = conta + pn+" ";
                bonus = bonus + 30;
                voltar();
            }
        });

        final Button num2 = (Button) findViewById(R.id.segundo_numero);
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topoVet++;
                contaVet[topoVet]=Integer.toString(sn);
                conta = conta + sn+" ";
                bonus = bonus + 30;
                voltar();
            }
        });



    }

    //Valor do Placar
    private static Integer placar = 500;
    public void limpaPlacar(){
        placar=500;
    }

    public static Integer getPlacar() {
        int valorPlacar = placar;
        return valorPlacar;
    }

    public void voltaPlacar(){
        TextView score = (TextView) findViewById(R.id.score);
        score.setText(""+placar);
    }

    //Valores digitados para fazer a cont
    private static String conta = "";
    private static String contaVet[] = new String[50];
    public static int topoVet = -1;

    //Bonus de placar
    private static  int bonus = 0;



    //Cria a lista com todos os valores digitados
    public void voltar(){
        TextView somatorio = (TextView) findViewById(R.id.somatorio);
        somatorio.setText(conta);
    }

    //Gera 2 numeros aleatorios pra o jogo
    Random r = new Random();
    int pn = r.nextInt(6)+1;
    int sn = r.nextInt(6)+1;

    int num1 = pn;
    int num2 = sn;


    //Caixa de Alerta exibindo os numeros sorteados
    public void exibirDicas(){
        AlertDialog.Builder msg = new AlertDialog.Builder(this);
        msg.setTitle("Dica:");
        msg.setMessage("Usando diferentes operadores \nvocê pode conseguir pontuações maiores!!!!!!!");
        msg.setPositiveButton("PRONTO!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(NivelUmActivity.this, "Que os jogos comecem!", Toast.LENGTH_SHORT).show();

            }


        });
        msg.show();
    }

    //Caixa de Alerta exibindo os numeros sorteados
    public void exibirNumeros(){
        AlertDialog.Builder msg = new AlertDialog.Builder(this);
        msg.setTitle("SEUS NÚMEROS SORTEADOS SÃO:");
        msg.setMessage(num1+ " E " + num2);
        msg.setPositiveButton("PROXIMO!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                exibirDicas();

            }


        });
        msg.show();
    }

    //Limpa a caixa de dialogo com os valores digitados
    public void limpar(){
        for (int i = 0; i <=contaVet.length; i++){
            contaVet[i] = null;

            /*Se o proximo valor da saída for nulo
             *   por não terem mais dados pra ler*/
            if (contaVet[i+1] == null ){
                i = contaVet.length;

            }
        }
        topoVet=-1;
        conta = "";
        voltar();
    }
    String calcularConta;
    String[] st = new String[50];

    public String[] getSt() {
        st = contaVet;
        return st;
    }

    public String getCalcularConta() {
        calcularConta = conta;
        return calcularConta;
    }

    //Valor resultdo da soma da expressão
    public void testando() {
        if(contaVet[0]==null){
            //Se nada foi digitado
            mensagemcontavazio();
        }else{
            //Se algo foi digitado
            CalcularExpressao calcularExpressao = new CalcularExpressao();
            calcularExpressao.CalcularExpressao();
            respostaExpressao = calcularExpressao.getValorComparar();
            contavazio=0;
        }
    }

    // Valor escolhido para a resposta
    ValorCartela numeroCartela = new ValorCartela();
    int resposta = numeroCartela.getCartela(0);

    //Confere se a resposta está certa
    public  void confereResposta(){
        testando();
        if(contavazio==0){
            if (resposta != respostaExpressao){
                errado();
                placar = placar - (placar * 3/100);
                voltaPlacar();
            }else{
                placar = placar + bonus;
                placar = placar*2;
                voltaPlacar();
                certo();
            }
        }
    }

    public  void errado(){
        fraseErrado();

    }

    public void fraseErrado(){
        Random errado = new Random();
        int err= errado.nextInt(6)+1;
        String msgerro;
        switch (err){
            case 1:
                msgerro = "Mas não desista!";
                break;
            case 2:
                msgerro = "Na próxima você consegue!";
                break;
            case 3:
                msgerro = "Mas foi por pouco, tente mais!";
                break;
            case 4:
                msgerro = "Mas não desanima, nem sempre se consegue de primeira!";
                break;
            case 5:
                msgerro = "Tente de novo, vocês cosegue!!";
                break;
            case 6:
                msgerro = "Quaaaaaaaase! Mas você ainda vai conseguir";
                break;
            default:
                msgerro = "Quaaaaaaase! Mas você ainda vai conseguir!";

        }

        AlertDialog.Builder msg = new AlertDialog.Builder(this);
        msg.setTitle("QUE PENA, VOCÊ ERROU!");
        msg.setMessage("Sua resposta foi: "+respostaExpressao+"\n" +
                "Mas queremos que seja: "+resposta+"\n"+msgerro);
        msg.setPositiveButton("CONTINUAR!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(NivelUmActivity.this, "Vamos de novo!", Toast.LENGTH_SHORT).show();

            }


        });
        msg.show();


    }

    public  void certo(){
        fraseCerto();

    }

    public void fraseCerto(){

        String msgcer;

        Random certo = new Random();
        int cer = certo.nextInt(5)+1;

        switch (cer){
            case 1:
                msgcer = "Dos matemáticos da sua idade \n" +
                        "você é o mais inteligente";
                break;
            case 2:
                msgcer = "Foi incrível...\n" +
                        "Certeza que você não é uma calculadora disfarçada?";
                break;
            case 3:
                msgcer = "Que incrível!\n" +
                        "Sua habilidade foi de mais de 9000!!!";
                break;
            case 4:
                msgcer = "Mas lembre-se: \n" +
                        "Com grandes acertos matemáticos, vem grandes responsabilidades...";
                break;
            default:
                msgcer = "Que incrível!\n" +
                        "Sua habilidade foi mais de 9000!";
        }


        AlertDialog.Builder msg = new AlertDialog.Builder(this);
        msg.setTitle("VOCÊ ACERTOU!!!!!!!!");
        msg.setMessage(msgcer);
        msg.setPositiveButton("PRÓXIMA FASE!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                proximaPG();
                Toast.makeText(NivelUmActivity.this, "Bem-Vindo a Fase 2!", Toast.LENGTH_SHORT).show();

            }


        });
        msg.show();

    }

    public  void proximaPG(){
        Intent nivelDois = new Intent(NivelUmActivity.this, NivelDoisActivity.class);
        startActivity(nivelDois);
        limpar();
        finish();
    }

    public void mensagemcontavazio(){
        String msgvazio = "Você precisa tentar fazer a conta antes de ver o resultado!";
        AlertDialog.Builder msg = new AlertDialog.Builder(this);
        msg.setTitle("CAMPO VAZIO!");
        msg.setMessage(msgvazio);
        msg.setPositiveButton("ENTENDI!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(NivelUmActivity.this, "Vamos de novo....", Toast.LENGTH_SHORT).show();

            }


        });
        msg.show();
        contavazio=1;

    }

}
