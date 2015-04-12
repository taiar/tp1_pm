package Pesquisadores;

import VeiculosDePublicacao.Artigo;

import java.util.ArrayList;
import Utilitarios.Dicionario;
import Utilitarios.ExcecaoChaveInexistente;

/**
 * Classe abstrata que representa um pesquisador, mais alto nivel na hierarquia
 */
public abstract class Pesquisador {
    // Identificador unico do pesquisador
    protected int id;

    // Autoria: key = ordem de autoria, value = numero de arquivos
    protected Dicionario<Integer, Integer> autoria = new Dicionario<>();
    protected ArrayList<Artigo> artigos = new ArrayList<Artigo>();

    public Pesquisador(int id){
        this.id = id;
    }

    /**
     * @return id do pesquisador
     */
    public int getId() {
        return this.id;
    }

    /**
     * Adiciona artigo a colecao do pesquisador
     * @param ordemAutoria
     */
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

    /**
     * @return Numero de artigos do pesquisador
     */
    public int getNumeroArtigos(){
        return this.autoria.size();
    }

    /**
     * @return Numero de citacoes do pesquisador
     */
    protected int getNumeroCitacoes() {
        int citacoes = 0;
        for (Artigo a : this.artigos){
            citacoes += a.getQuantidadeDeCitacoes();
        }
        return citacoes;
    }

    /**
     * Calcula o peso do pesquisador
     * @return peso calculado
     */
    private double peso() {
        double pesoTotal = 0;

        ArrayList<Integer> chaves = autoria.keys();
        System.out.println("Autorias " + chaves + " para id " + this.getId());

        int quantidadeAutorias;

        // Peso: somatorio do numero de autorias para certa ordem / ordem
        // Exemplo: 2 como 1o autor e 5 como 2o geram peso 2/1 + 5/2 = 4.5
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
    }

    /**
     * Realiza o calculo de popularidade para o pesquisador
     * @return popularidade do pesquisador
     */
    public double popularidade() {
        return this.peso() + this.getNumeroArtigos() + this.getNumeroCitacoes();
    }

    /**
     * @return peso do pesquisador
     */
    public double getPeso() {
        return this.peso();
    }

    /**
     * @return lista de citacoes do pesquisador
     */
    public int getCitacoes() {
        return this.getNumeroCitacoes();
    }

    /**
     * Adiciona artigo a listagem do pesquisador
     * @param artigo
     */
    public void adicionaArtigo(Artigo artigo) {
        this.artigos.add(artigo);
    }

    /**
     * @return id do pesquisador
     */
    public String toString(){
        return "ID do Pesquisador: " + id;
    }

    /**
     * @return tipo do pesquisador
     */
    public String getTipo() {
        return "Genérico";
    }

    /**
     * @return lista de autorias do pesquisador
     */
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

