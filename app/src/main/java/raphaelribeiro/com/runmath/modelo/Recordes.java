package raphaelribeiro.com.runmath.modelo;

import androidx.annotation.NonNull;

public class Recordes {
    private Long id;
    private String nome;
    private int pontos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    @NonNull
    @Override
    public String toString() {
        return getNome() + " : " + getPontos() + " Pontos";
    }
}
