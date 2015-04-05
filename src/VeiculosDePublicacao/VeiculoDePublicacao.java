package VeiculosDePublicacao;

import java.util.ArrayList;

public abstract class VeiculoDePublicacao {
    
    protected int id;

    /**
     * Número de artigos presentes no veículo.
     */
    protected int numeroDeArtigos;

    /**
     * Número de vezes que um artigo presente no veículo foi citado.
     */
    protected int numeroDeCitacoes;

    protected ArrayList<Artigo> Artigos;

    public VeiculoDePublicacao(int id){
        this.id = id;
    }

    public float fatorDeImpacto(){
        return this.numeroDeCitacoes / this.numeroDeArtigos;
    }
    
    public String toString(){
        return "ID da Publicacao: " + id;
    }
}
