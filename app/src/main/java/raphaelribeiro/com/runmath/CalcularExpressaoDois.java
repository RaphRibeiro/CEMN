package raphaelribeiro.com.runmath;

import java.util.ArrayList;
import java.util.List;

public class CalcularExpressaoDois {
    private static  String paux[];
    private  static String saida[];
    private static String calcResultado[];
    private static String saidasemPar[];
    private static String auxPar[];
    private static  String comparar;
    private int valorComparar;

    public int getValorComparar() {
        valorComparar = Integer.parseInt(comparar);
        return valorComparar;
    }

    int topo;
    int topoaux;
    int topoResult;
    int resultadoFinal;

    private static String[] vetor = new String[50];

    //Lista de Números e Símbolos
    private  static List<Character> numeros = new ArrayList<>();
    private  static List<Character> sinal = new ArrayList<>();

    //Preenche Lista de Números do Dado
    public  void ListaNum(){
        numeros.add('1');
        numeros.add('2');
        numeros.add('3');
        numeros.add('4');
        numeros.add('5');
        numeros.add('6');
    }
    //Preenche Lista de Operadores
    public  void ListaSinais(){
        sinal.add('x');
        sinal.add('/');
        sinal.add('+');
        sinal.add('-');
        sinal.add('(');
        sinal.add(')');
    }

    NivelDoisActivity nvl2 = new NivelDoisActivity();
    String[] str = nvl2.getSt();
//    NivelUmActivity nvl1 = new NivelUmActivity();

    public void CalcularExpressao(){
        //Teste Shuting Yard
        // expressão:2*3+4*(5-6)
//        vetor[0] = "2";
//        vetor[1] = "x";
//        vetor[2] = "2";
//        vetor[3] = "x";
//        vetor[4] = "2";
//        vetor[5] = "-";
//        vetor[6] = "1";
//        vetor[7] = "x";
//        vetor[8] = "(";
//        vetor[9] = "5";
//        vetor[10] = "-";
//        vetor[11] = "6";
//        vetor[12] = ")";


        //Apagando o que tem no vetor
        for (int i = 0; i <=vetor.length; i++){
            vetor[i] = null;

            /*Se o proximo valor da saída for nulo
             *   por não terem mais dados pra ler*/
            if (vetor[i+1] == null ){
                i = vetor.length;

            }
        }

        for(int n = 0; n <= vetor.length; n++){
            if(!str[n].equals(null)) {
                vetor[n] = str[n];
            }

            /*Se o proximo valor da saída for nulo
             *   por não terem mais dados pra ler*/
            if (str[n+1] == null ){
                n = vetor.length;

            }
        }
        int temPar =0;
        for(int i =0; i <= vetor.length; i++){
            if(vetor[i].equals("(")){
                temPar=1;
//                i = vetor.length;
            }
            /*Se o proximo valor do vetor for nulo
             *   por não terem mais dados pra ler*/
            if (vetor[i+1] == null ){
                i = vetor.length;
            }
        }

        paux = new String[30];
        saida = new String[50];
        calcResultado = new String[50];

        topo = -1;
        topoaux = -1;
        int ant = -1;
        ListaNum();
        ListaSinais();

        if(temPar==1){
            //Removendo parentese e passando pra polonesa inversa
            for (int cont = 0; cont <= vetor.length; cont++){
                //Se for um número:
                //            if ((vetor[cont] == "1")||(vetor[cont] == "2")||(vetor[cont] == "3")||(vetor[cont] == "4")||(vetor[cont] == "5")||(vetor[cont] == "6")) {
                if ((!vetor[cont].equals("/"))&&(!vetor[cont].equals("x"))&&(!vetor[cont].equals("+"))&&(!vetor[cont].equals("-"))&&(!vetor[cont].equals("("))&&(!vetor[cont].equals(")"))) {
                    topo++;
                    saida[topo] = vetor[cont];
                }
                //Se for Operador
                if ((vetor[cont] == "/")||(vetor[cont] == "x")||(vetor[cont] == "+")||(vetor[cont] == "-")||(vetor[cont] == "(")||(vetor[cont] == ")")) {
                    topoaux++;
                    paux[topoaux] = vetor[cont]; // Topo recebe operador
                    int controle = 0;
                    //se topo não for  x ou /
                    if((!paux[topoaux].equals("x"))&&(!paux[topoaux].equals("/")&&(!paux[topoaux].equals("(")))&&(!paux[topoaux].equals(")"))){
                        while (controle==0){
                            controle=1;
                            ant=topoaux-1;
                            if((ant>=0)){
                                //se a segunda posição for x ou /
                                if((paux[ant]=="x")||(paux[ant]=="/")){
                                    controle=0;
                                    topo++;
                                    saida[topo] = paux[ant];
                                    paux[ant]=paux[topoaux];
                                    topoaux--;
                                    ant = topoaux -1;
                                    if(ant<0){
                                        controle=1;
                                    }
                                }
                            }
                        }
                    }
                    //Se é fech Parenteses
                    if(paux[topoaux].equals(")")){
                        int fechaPar = 0;
                        while (fechaPar == 0){
                            topoaux--;
                            topo++;
                            saida[topo] = paux[topoaux];
                            ant = topoaux-1;
                            if (paux[ant].equals("(")){
                                fechaPar = 1;
                                topoaux = topoaux -2;
                            }
                        }
                    }

                }//Fecha se for Operador

                /*Se o proximo valor do vetor for nulo
                 *   por não terem mais dados pra ler*/
                if (vetor[cont+1] == null ){
                    while(topoaux>=0){
                        topo++;
                        saida[topo]=paux[topoaux];
                        topoaux--;
                    }
                    cont = vetor.length;

                }

            }//fecha for

            //Fazendo a soma
            //Notação Polonesa Inversa
            topo=-1;
            topoResult=-1;
            for (int cont = 0; cont <= saida.length; cont++ ){
                int nUm, nDois;
                //Se for número, põe na pilha
                if ((!saida[cont].equals("+"))&&(!saida[cont].equals("-"))&&(!saida[cont].equals("x"))&&(!saida[cont].equals("/"))){
                    topoResult++;
                    calcResultado[topoResult] = saida[cont];
                }
                //Se for operador, faz a conta
                if ((saida[cont].equals("/"))||(saida[cont].equals("x"))||(saida[cont].equals("+"))||(saida[cont].equals("-"))){
                    topoResult++;
                    calcResultado[topoResult] = saida[cont];
                    nUm=topoResult-1;
                    nDois = topoResult-2;

                    // *** SOMA ***
                    if (calcResultado[topoResult].equals("+")){
                        resultadoFinal = Integer.parseInt(calcResultado[nDois]) + Integer.parseInt(calcResultado[nUm]);
                        topoResult = topoResult-2;
                        calcResultado[topoResult] = Integer.toString(resultadoFinal);
                    }

                    // *** SUBTRAÇÃO ***
                    if (calcResultado[topoResult].equals("-")){
                        resultadoFinal = Integer.parseInt(calcResultado[nDois]) - Integer.parseInt(calcResultado[nUm]);
                        topoResult = topoResult-2;
                        calcResultado[topoResult] = Integer.toString(resultadoFinal);
                    }

                    // *** MULTIPLICAÇÃO ***
                    if (calcResultado[topoResult].equals("x")){
                        resultadoFinal = Integer.parseInt(calcResultado[nDois]) * Integer.parseInt(calcResultado[nUm]);
                        topoResult = topoResult-2;
                        calcResultado[topoResult] = Integer.toString(resultadoFinal);
                    }

                    // *** DIVISÃO ***
                    if (calcResultado[topoResult].equals("/")){
                        resultadoFinal = Integer.parseInt(calcResultado[nDois]) / Integer.parseInt(calcResultado[nUm]);
                        topoResult = topoResult-2;
                        calcResultado[topoResult] = Integer.toString(resultadoFinal);
                    }

                    //                String resposta = calcResultado[topoResult];
                    //                System.out.println(resposta);
                    //                comparar = resposta;
                }//Fim se for operador

                /*Se o proximo valor da saída for nulo
                 *   por não terem mais dados pra ler*/
                if (saida[cont+1] == null ){
                    cont = saida.length;

                }
            }// Fecha for

            //Apagando o que tem no vetor de saída
            for (int i = 0; i <=saida.length; i++){
                saida[i] = null;

                /*Se o proximo valor da saída for nulo
                 *   por não terem mais dados pra ler*/
                if (saida[i+1] == null ){
                    i = saida.length;

                }
            }
            //Se o número for negativo
//            if(Integer.parseInt(calcResultado[topoResult])<0){
//                int negativo = Integer.parseInt(calcResultado[topoResult])*-1;
//                calcResultado[topoResult] = Integer.toString(negativo);
//            }
            comparar = calcResultado[topoResult];
        }


        //Se a expressão for sem parenteses
        saidasemPar = new String[50];
        auxPar = new String[50];
        int topoSemPar =-1;
        int anterior = -1;
        int proximo = -1;
        int respSemPar;
        if(temPar ==0){
            for(int cont = 0; cont<= vetor.length; cont++){
                topoSemPar++;
                saidasemPar[topoSemPar] = vetor[cont];
                if((vetor[cont].equals("x"))||(vetor[cont].equals("/"))){
                    anterior = topoSemPar-1;
                    proximo = cont+1;
                    // *** MULTIPLICAÇÃO ***
                    if (vetor[cont].equals("x")){
                        respSemPar = Integer.parseInt(saidasemPar[anterior]) * Integer.parseInt(vetor[proximo]);
                        topoSemPar--;
                        saidasemPar[topoSemPar]= Integer.toString(respSemPar);
                        cont++;
                    }
                    // *** DIVISÃO ***
                    if (vetor[cont].equals("/")){
                        respSemPar = Integer.parseInt(saidasemPar[anterior]) / Integer.parseInt(vetor[proximo]);
                        topoSemPar--;
                        saidasemPar[topoSemPar]= Integer.toString(respSemPar);
                        cont++;
                    }
                }//Fim se é Multiplicação ou Divisão
                /*Se o proximo valor do vetor for nulo
                 *   por não terem mais dados pra ler*/
                if (vetor[cont+1] == null ){
                    cont = vetor.length;

                }
            }// Fim For

            int topoauxpar=-1;
            int resp;
            for(int cont = 0; cont<=saidasemPar.length;cont++){
                topoauxpar++;
                auxPar[topoauxpar] = saidasemPar[cont];
                anterior = topoauxpar-1;
                proximo = cont+1;
                // *** SOMA ***
                if(saidasemPar[cont].equals("+")){
                    resp = Integer.parseInt(auxPar[anterior]) + Integer.parseInt(saidasemPar[proximo]);
                    topoauxpar--;
                    auxPar[topoauxpar] = Integer.toString(resp);
                    cont++;
                }
                // *** SUBTRAÇÃO ***
                if(saidasemPar[cont].equals("-")){
                    resp = Integer.parseInt(auxPar[anterior]) - Integer.parseInt(saidasemPar[proximo]);
                    topoauxpar--;
                    auxPar[topoauxpar] = Integer.toString(resp);
                    cont++;
                }


                /*Se o proximo valor do vetor for nulo
                 *   por não terem mais dados pra ler*/
                if ((saidasemPar[cont+1]==null)||(saidasemPar[cont+1].equals("/"))||saidasemPar[cont+1].equals("x") ){
                    cont = saidasemPar.length;

                }

                comparar = auxPar[topoauxpar];
            }

        }//Fim se não tem parentese


    }//fecha calcular expressao
}
