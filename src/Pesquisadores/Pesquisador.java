package Pesquisadores;

import VeiculosDePublicacao.Artigo;

import java.util.ArrayList;
import Utilitarios.DicionarioHash;
import Utilitarios.ExcecaoChaveInexistente;

public abstract class Pesquisador {
    
    protected int id;

    protected DicionarioHash<Integer, Integer> autoria = new DicionarioHash<>();
    protected ArrayList<Artigo> artigos = new ArrayList<Artigo>();

    public Pesquisador(int id){
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void addArtigo(int ordemAutoria) {
        int numeroAutoria = 0;

        try{
            numeroAutoria = this.autoria.get(ordemAutoria);
        }catch(ExcecaoChaveInexistente e) {
            // Caso nao exista nenhuma autoria de dada ordem, inicializo com 1
            this.autoria.put(ordemAutoria, 1);
        }

        this.autoria.put(ordemAutoria, numeroAutoria + 1);
    }

    public int getNumeroArtigos(){
        return this.autoria.size();
    }

    protected int getNumeroCitacoes() {
        int citacoes = 0;
        for (Artigo a : this.artigos){
            citacoes += a.getQuantidadeDeCitacoes();
        }
        return citacoes;
    }

    private double peso() {
        double pesoTotal = 0;

        // Acho que nao tem como calcular o peso usando hash
        /*for(int i = 1; i <= this.autoriaMaxima; i++){
            pesoTotal += this.autoria.get(i - 1) / (double) i;
        }*/

        return pesoTotal;
        /*return (double) autoria[0] + (autoria[1] / 2.0) + (autoria[2] / 3.0) + (autoria[3] / 4.0) + (autoria[4] / 5.0)
                + (autoria[5] / 6.0) + (autoria[6] / 7.0) + (autoria[7] / 8.0) + (autoria[8] / 9.0) +
                (autoria[9] / 10.0);*/
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

    public String getAutorias() {
        String autorias = "";
        //p.autoria[0] + "," + p.autoria[1] + "," + p.autoria[2] + "," + p.autoria[3] + "," + p.autoria[4] + ")";
        // Tambem preciso ver como obter autorias usando o hash
        /*for(int i = 0; i < this.autoriaMaxima; i++){
            autorias += String.valueOf(this.autoria.get(i));
            if(i < this.autoriaMaxima - 1){
                autorias += ",";
            }
        }*/

        return autorias;
    }
}

