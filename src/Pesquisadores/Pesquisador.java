package Pesquisadores;

import VeiculosDePublicacao.Artigo;

import java.util.ArrayList;
import Utilitarios.Dicionario;
import Utilitarios.ExcecaoChaveInexistente;

public abstract class Pesquisador {
    
    protected int id;

    // Autoria: key = ordem de autoria, value = numero de arquivos
    protected Dicionario<Integer, Integer> autoria = new Dicionario<>();
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

        ArrayList<Integer> chaves = autoria.keys();
        System.out.println("Autorias " + chaves + " para id " + this.getId());

        int quantidadeAutorias;

        for (Integer ordemAutoria : chaves) {
            try {
                quantidadeAutorias = this.autoria.get(ordemAutoria);
                pesoTotal += quantidadeAutorias / (double) ordemAutoria;
                System.out.println("Id " + this.getId() + ": " + quantidadeAutorias + " autorias para ordem " + ordemAutoria);
            } catch (ExcecaoChaveInexistente e) {
                System.out.println("Chave inexistente no calculo de peso para chave: " + ordemAutoria);
            }
        }

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

        ArrayList<Integer> chaves = this.autoria.keys();
        ArrayList<Integer> valores = this.autoria.values();

        int quant = chaves.size();

        for(int i = 0; i < quant; i++){
            autorias += chaves.get(i) + ": " + valores.get(i);
            if(i != (quant - 1)) autorias += ", ";
        }

        return autorias;
    }
}

