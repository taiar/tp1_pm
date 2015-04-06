package Pesquisadores;

import VeiculosDePublicacao.Artigo;

import java.util.ArrayList;

public abstract class Pesquisador {
    
    protected int id;

    private int[] autoria = new int[10];
    protected int citacoes;
    protected ArrayList<Artigo> artigos = new ArrayList<>();

    public Pesquisador(int id){
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void addArtigo(int ordemAutoria) {
        this.autoria[ordemAutoria - 1] += 1;
    }

    protected int getNumeroArtigos(){
        return autoria[0] + autoria[1] + autoria[2];
    }

    protected int getNumeroCitacoes() {
        int citacoes = 0;
        for (Artigo a : artigos){
            citacoes += a.getQuantidadeDeCitacoes();
        }
        return citacoes;
    }

    private double peso() {
        return (double) autoria[0] + (autoria[1] / 2.0) + (autoria[2] / 3.0);
    }

    protected double popularidade(){
        return this.peso() + this.getNumeroArtigos() + this.getNumeroCitacoes();
    }

    public double getPopularidade() {
        return this.popularidade();
    }

    public void adicionaArtigo(Artigo artigo) {
        this.artigos.add(artigo);
    }

    public String toString(){
        return "ID do Pesquisador: " + id;
    }
}

