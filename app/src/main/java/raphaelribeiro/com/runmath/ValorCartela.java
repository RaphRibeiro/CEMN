package raphaelribeiro.com.runmath;

import androidx.appcompat.app.AppCompatActivity;

public class ValorCartela {

    //Descobre qual o botão foi escolhido, para gerar o resultado

    private int cartela;
    private static int valor;

    //Retorna o valor escolhido, pra a classe NivelUmActivity
    public static int getCartela(int num) {
        num  = valor;
        return num;
    }

    //Switch para comprar e descobrir qual o valor escolhido na classe Cartelas
    public void setCartela(int cartela) {
        switch (cartela){
            case 1:
                valor = 1;
                break;
            case 2:
                valor = 2;
                break;
            case 3:
                valor = 3;
                break;
            case 4:
                valor = 4;
                break;
            case 5:
                valor = 5;
                break;
            case 6:
                valor = 6;
                break;
            case 7:
                valor = 7;
                break;
            case 8:
                valor = 8;
                break;
            case 9:
                valor = 9;
                break;
            case 10:
                valor = 10;
                break;
            case 11:
                valor = 11;
                break;
            case 12:
                valor = 12;
                break;
            default:
                valor = 0;
        }
        this.cartela = cartela;
    }

}
