package Pesquisadores;

import VeiculosDePublicacao.Artigo;

import java.util.ArrayList;

public abstract class Pesquisador {
    
    protected int id;

    // TODO: tornar isso um ArrayColletcion
    public int[] autoria = new int[10];
    protected ArrayList<Artigo> artigos = new ArrayList<Artigo>();

    public Pesquisador(int id){
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void addArtigo(int ordemAutoria) {
        this.autoria[ordemAutoria - 1] += 1;
    }

    public int getNumeroArtigos(){
        return autoria[0] + autoria[1] + autoria[2] + autoria[3]  + autoria[4] + autoria[5] + autoria[6] + autoria[7]
                + autoria[8] + autoria[9];
    }

    protected int getNumeroCitacoes() {
        int citacoes = 0;
        for (Artigo a : this.artigos){
            citacoes += a.getQuantidadeDeCitacoes();
        }
        return citacoes;
    }

    private double peso() {
        return (double) autoria[0] + (autoria[1] / 2.0) + (autoria[2] / 3.0) + (autoria[3] / 4.0) + (autoria[4] / 5.0)
                + (autoria[5] / 6.0) + (autoria[6] / 7.0) + (autoria[7] / 8.0) + (autoria[8] / 9.0) +
                (autoria[9] / 10.0);
    }

    public double popularidade() {
        return this.peso() + this.getNumeroArtigos() + this.getNumeroCitacoes();
    }

    public double getPopularidade() {
        return this.popularidade();
    }

    public double getPeso() {
        return this.peso();
    }

    public int getCitacoes() {
        return this.getNumeroCitacoes();
    }

    public void adicionaArtigo(Artigo artigo) {
        this.artigos.add(artigo);
    }

    public String toString(){
        return "ID do Pesquisador: " + id;
    }

    public String getTipo() {
        return "Genérico";
    }
}

