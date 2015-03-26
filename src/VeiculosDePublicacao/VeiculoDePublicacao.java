package VeiculosDePublicacao;

import java.util.ArrayList;

public abstract class VeiculoDePublicacao {
    private int id;

    private int numeroDeArtigos;

    private ArrayList<Artigo> Artigos;

    public VeiculoDePublicacao(int id){
        this.id = id;
    }

    public float fatorDeImpacto(){
        /* @todo o correto eh numero de citacoes / numero de artigos */
        return this.numeroDeArtigos;
    }
    
    public String toString(){
        return "ID da publicacao: " + id;
    }
}
